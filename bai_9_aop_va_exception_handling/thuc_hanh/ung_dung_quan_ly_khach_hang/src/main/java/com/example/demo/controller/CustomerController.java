package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.CustomerService;
import com.example.demo.service.DuplicateEmailException;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public String showList(@RequestParam("s") Optional<String> s, Model model,@PageableDefault(size = 3) Pageable pageable) throws Exception {
        Page<Customer> customers;
        if (s.isPresent()) {
            customers = customerService.findAllByFirstNameContaining(s.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("customer/{id}")
    public ModelAndView showInformation(@PathVariable(required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView("customer/info");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping
    public String updateCustomer(Customer customer) throws DuplicateEmailException{
            customerService.save(customer);
            return "redirect:/";
    }

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }
    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("customer/inputs-not-acceptable");
    }
}
