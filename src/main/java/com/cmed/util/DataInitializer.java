package com.cmed.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cmed.model.User;
import com.cmed.repository.UserRepository;

//@Configuration
//public class DataInitializer {
//
//    @Bean
//    CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        return args -> {
//            // Check if user already exists
//            if (userRepository.findByUsername("admin").isEmpty()) {
//                User user = new User();
//                user.setUsername("admin");
//                user.setPassword(passwordEncoder.encode("1234")); // raw password '1234'
//                user.setName("Admin User");
//                user.setUserRole("ADMIN");
//                userRepository.save(user);
//                System.out.println("Admin user created with username: admin, password: 1234");
//            }
//        };
//    }
//}
