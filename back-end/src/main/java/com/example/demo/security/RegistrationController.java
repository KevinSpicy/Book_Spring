package com.example.demo.security;

import com.example.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute
    private RegistrationForm registrationForm() {
        return new RegistrationForm();
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute RegistrationForm registrationForm) {
        if (!registrationForm.getPassword().equals(registrationForm.getConfirm())) {
            return "registration";
        }
        userRepository.save(registrationForm.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
