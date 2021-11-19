package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @PostMapping("/calculate")
    public String calculate(@RequestParam String number1, String number2, String calculate, Model model){
        float result;
        switch (calculate){
            case "Add":
                result = Float.parseFloat(number1) + Float.parseFloat(number2);
                break;
            case "Sub":
                result = Float.parseFloat(number1) - Float.parseFloat(number2);
                break;
            case "Mul":
                result = Float.parseFloat(number1) * Float.parseFloat(number2);
                break;
            case "Div":
                result = Float.parseFloat(number1) / Float.parseFloat(number2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculate);
        }
        model.addAttribute("result", result);
        return "index";
    }
}
