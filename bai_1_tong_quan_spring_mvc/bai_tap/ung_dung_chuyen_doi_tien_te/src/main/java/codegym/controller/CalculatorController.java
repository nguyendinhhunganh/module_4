package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String display() {
        return "Calculator";
    }

    @PostMapping("/change")
    public String change(@RequestParam String usd, String rate, Model model) {
        float vnd = Float.parseFloat(usd) * Float.parseFloat(rate);
        model.addAttribute("vnd", vnd);
        return "Calculator";
    }

}
