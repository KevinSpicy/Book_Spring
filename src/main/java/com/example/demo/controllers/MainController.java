package com.example.demo.controllers;

import com.example.demo.dao.JdbcTemplateUser;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller("/")
public class MainController {

    @Autowired
    JdbcTemplateUser jdbcTemplateUser;

    @GetMapping("/")
    public String view() {
        return "/home";
    }

    @GetMapping("/users")
    public String userView(Model model) {
        model.addAttribute("USERS", jdbcTemplateUser.getAll());
        return "/users";
    }

    @GetMapping("/users/new")
    public String viewCreator() {
        return "/sign_up";
    }

    @PostMapping("/users/new")
    public String createUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/users";
        }

        user.setCreateAt(new Date());
        jdbcTemplateUser.save(user);
        return "redirect:/users";
    }
}
