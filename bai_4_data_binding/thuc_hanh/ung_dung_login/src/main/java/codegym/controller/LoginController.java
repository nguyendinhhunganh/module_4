package codegym.controller;

import codegym.model.Login;
import codegym.model.User;
import codegym.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/home")
    public String home(Model model){
        Login login = new Login();
        model.addAttribute("login", login);
        return "home";
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserService.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("Error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("User");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
