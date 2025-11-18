package com.example.Employee.Management.System.CustomFilter;

import com.example.Employee.Management.System.Securityservices.CustomeUserDetailService;
import com.example.Employee.Management.System.services.implement.Jwtservice;
import jakarta.persistence.Access;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private Jwtservice jwtservice;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader=request.getHeader("Authorization");
        String email=null;
        String token=null;

        if(authHeader!=null&&authHeader.startsWith("Bearer "))
        {
            token=authHeader.substring(7);
            email=jwtservice.extractemail(token);
        }
        if(email!=null&& SecurityContextHolder.getContext().getAuthentication()==null)
        {
            UserDetails userDetails=applicationContext.getBean(CustomeUserDetailService.class).loadUserByUsername(email);
            if(jwtservice.verification(token,userDetails))
            {
                UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);

            }
        }
        filterChain.doFilter(request,response);
    }
}
