package codegym.controller;

import codegym.model.Product;
import codegym.service.Impl.ProductServiceImpl;
import codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

@Controller
public class ProductController {
    ProductService productService = new ProductServiceImpl();
    @GetMapping("/")
    public String index(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }
    @GetMapping("/product/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("product/save")
    public String save(Product product){
        product.setId((int)Math.random()*10000);
        productService.save(product);
        return "redirect:/";
    }
    @GetMapping("/product/{id}/edit")
    public String edit(Model model, @PathVariable int id){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("product/update")
    public String update(Product product){
        productService.update(product.getId(), product);
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }
    @PostMapping("product/delete")
    public String delete( Product product){
        productService.remove(product.getId());
        return "redirect:/";
    }
}
