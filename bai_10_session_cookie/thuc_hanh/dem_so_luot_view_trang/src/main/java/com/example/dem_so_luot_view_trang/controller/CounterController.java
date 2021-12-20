package com.example.dem_so_luot_view_trang.controller;

import com.example.dem_so_luot_view_trang.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("myCounter")
public class CounterController {

    /* add MyCounter in model attribute */
    @ModelAttribute("myCounter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("myCounter") MyCounter myCounter) {
        myCounter.increment();
        return "index";
    }
}