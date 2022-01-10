package com.example.internationalize.controller;

import com.example.internationalize.model.Credential;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model) {
        Credential credential = new Credential();
        model.addAttribute("credential", credential);
        return "login";
    }
}
