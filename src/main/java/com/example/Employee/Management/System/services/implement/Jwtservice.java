package com.example.Employee.Management.System.services.implement;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class Jwtservice {

    private String key="";

    public Jwtservice() {
        try {
            KeyGenerator keyGenerator=KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk=keyGenerator.generateKey();
            key=Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String email) {

        Map<String,Object> claims=new HashMap<>();

        return Jwts.builder().claims().add(claims)
                        .subject(email).
                issuedAt(new Date(System.currentTimeMillis())).
                expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 1)).
                and().
                signWith(generateKey()).
                compact();
    }

    private SecretKey generateKey() {
        byte[]keyByte= Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(keyByte);
    }

    public String extractemail(String token) {

    return extractClaim(token, Claims::getSubject);
    }

    private <T>T extractClaim(String token, Function<Claims,T>claimsTFunction) {
        final Claims claims=extractAllclaims(token);
        return claimsTFunction.apply(claims);

    }

    private Claims extractAllclaims(String token) {

        return Jwts.parser().verifyWith(generateKey()).build().parseSignedClaims(token).getPayload();

    }

    public boolean verification(String token, UserDetails userDetails) {

        final String email=extractemail(token);

        return email.equals(userDetails.getUsername())&&!TokenExpired(token);
    }

    private boolean TokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {

        return extractClaim(token,Claims::getExpiration);
    }
}
