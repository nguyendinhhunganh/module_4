package com.example.tao_gio_hang.controller;

import com.example.tao_gio_hang.model.Cart;
import com.example.tao_gio_hang.model.Product;
import com.example.tao_gio_hang.repository.ProductRepository;
import com.example.tao_gio_hang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ProductService productService;

    @GetMapping("buy")
    public String getCart(@SessionAttribute("carts") HashMap<Long, Cart> hashMap, Model model ){
        model.addAttribute("carts", hashMap);
        model.addAttribute("cartNum", hashMap.size());
        model.addAttribute("cartMoney", totalPrice(hashMap));
        return "cart";
    }

    @GetMapping("buy/{id}")
    public String addProductToCart(@PathVariable Long id, @SessionAttribute("carts") HashMap<Long, Cart> hashMap, Model model){

        Product product = productService.findById(id);

        if (product != null) {
            if ( !hashMap.containsKey(id) ) {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                hashMap.put(id, item);
            } else {
                Cart item = hashMap.get(id);
                item.setQuantity( item.getQuantity() + 1);
                hashMap.put(id, item);
            }
        }
        model.addAttribute("carts", hashMap);
        model.addAttribute("cartNum", hashMap.size());
        model.addAttribute("cartMoney", totalPrice(hashMap));
        return "cart";
    }

    public double totalPrice(HashMap<Long, Cart> cartHashMap) {
        int count = 0;
        for (Map.Entry<Long, Cart> list : cartHashMap.entrySet()) {
            count += Double.parseDouble(list.getValue().getProduct().getNewPrice()) * list.getValue().getQuantity();
        }
        return count;
    }
}
