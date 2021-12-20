package com.example.validate_form_dang_ky.controller;

import com.example.validate_form_dang_ky.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String formUser(Model model) {
        model.addAttribute("user" , new User());
        return "FormUser";
    }

    @PostMapping("/")
    public String insertUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()) {
            return "FormUser";
        }
        return "Result";
    }
}
