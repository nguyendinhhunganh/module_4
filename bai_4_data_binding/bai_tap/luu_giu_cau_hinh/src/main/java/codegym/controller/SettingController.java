package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
}
