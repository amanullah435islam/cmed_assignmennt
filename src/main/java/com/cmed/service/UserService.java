package com.cmed.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cmed.model.User;
import com.cmed.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    
    public User createUser(String username, String rawPassword, String name, String role) {
        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setUserRole(role);
        // ✅ User যে password দিয়েছে সেটা BCrypt encode হবে
        user.setPassword(passwordEncoder.encode(rawPassword));
        return userRepository.save(user);
    }

    // ✅ নতুন ইউজার রেজিস্টার (password encode সহ)
    public User saveUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("❌ Username already exists!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // ✅ সব ইউজার দেখার জন্য
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ ID দিয়ে ইউজার বের করা
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("❌ User not found with ID: " + id));
    }

    // ✅ Username দিয়ে ইউজার বের করা
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("❌ User not found with username: " + username));
    }

    // ✅ Spring Security authentication-এর জন্য ব্যবহার হবে
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getUserRole())  // "ADMIN", "DOCTOR", etc.
                .build();
    }
    
    
//    // ✅ Load user for authentication ---// same way to get user:::::::::
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getUsername())
//                .password(user.getPassword()) // already encoded
//                .roles(user.getUserRole())
//                .build();
//    }

   

 


//        // ✅ Registration method
//        public User registerUser(User user) {
//            // Encode password before saving
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            return userRepository.save(user);
//        }

    public boolean registerUser(User user) {
        // Check if username already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            return false; // already exists
        }

        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
    
    

        public Optional<User> findByUsername(String username) {
            return userRepository.findByUsername(username);
        }
    }


