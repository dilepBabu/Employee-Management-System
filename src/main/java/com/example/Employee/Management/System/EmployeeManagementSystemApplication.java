package com.example.Employee.Management.System;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}
//	@Bean
//	CommandLineRunner run() {
//		return args -> {
//			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
//			System.out.println("Encoded: " + encoder.encode("12345"));
//		};
//	}
}
