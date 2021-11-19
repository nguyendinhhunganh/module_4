package codegym.controller;

import codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @GetMapping("/showForm")
    public String showForm(Model model)
    {
        model.addAttribute("employee", new Employee());
        return "creat";
    }
    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee, BindingResult result, ModelMap model){
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "info";
    }
}
