package com.cmed.controller;

import com.cmed.model.User;
import com.cmed.repository.UserRepository;
import com.cmed.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;


// ////// ----// normal h2 database code without registe methods:::::::::::::::::
@Controller  
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // ✅ Login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // ✅ Process login
//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        HttpSession session,
//                        Model model) {
//
//        User user = userRepository.findByUsername(username);
//
//        if (user != null && user.getPassword().equals(password)) {
//            // Login success → set session
//            session.setAttribute("loggedUser", user);
//            return "redirect:/prescriptions";
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//    }
    
    
    // //using optional::::::::
    
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        User user = userRepository.findByUsername(username)
                        .filter(u -> u.getPassword().equals(password))
                        .orElse(null);

        if (user != null) {
            session.setAttribute("loggedUser", user);
            return "redirect:/prescriptions";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }


    // ✅ Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }



    // // using register code::::::::::
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // return register.html or register.jsp
    }

//    @PostMapping("/register")
//    public String register(@ModelAttribute User user, Model model) {
//        userService.registerUser(user);
//        model.addAttribute("success", "User registered successfully!");
//        return "login"; // after registration, redirect to login page
//    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        boolean registered = userService.registerUser(user);

        if (!registered) {
            model.addAttribute("error", "⚠️ Username already exists! Please try another one.");
            return "register"; // stay on the same page
        }

        model.addAttribute("success", "✅ Registration successful! Please login.");
        return "login";
    }
}
