package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwickController {
    @GetMapping({"","/controller"})
    public String save() {
        return "index";
    }
    @PostMapping("/controllersave")
    public String save(@RequestParam(required = false) String[] condiment, Model model){
        model.addAttribute("condiments", condiment);
        System.out.println(Arrays.toString(condiment));
        return "index";
    }
}
