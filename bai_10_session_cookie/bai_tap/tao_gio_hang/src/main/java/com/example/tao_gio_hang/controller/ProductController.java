package com.example.tao_gio_hang.controller;


import com.example.tao_gio_hang.model.Cart;
import com.example.tao_gio_hang.model.Product;
import com.example.tao_gio_hang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@SessionAttributes("carts")
public class ProductController {

    @Autowired
    private ProductService productService;


    @ModelAttribute("carts")
    public HashMap<Long, Cart> cartHashMap() {
        return new HashMap<>();
    }

    @GetMapping("/list")
    public String showList(Model model, HttpSession session) {
        session.getAttribute("carts");
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/product/create")
    public String showFormCreate(@ModelAttribute("carts") HashMap<Long, Cart> hashMap, Model model) {
        model.addAttribute("product", new Product());
        return "create";

    }

    @PostMapping("/product/create")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "New product created successfully");
        return "redirect:/list";
    }

    @GetMapping("/view/product/{id}")
    public String viewProduct(@PathVariable Long id, Model model, @ModelAttribute("carts") HashMap<Long, Cart> cartHashMap
    ) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@ModelAttribute Product product, @PathVariable Long id) {
        productService.remove(id);
        return "redirect:/list";
    }

    @GetMapping("/cart/list")
    public String listCart() {
        return "cart";
    }

}