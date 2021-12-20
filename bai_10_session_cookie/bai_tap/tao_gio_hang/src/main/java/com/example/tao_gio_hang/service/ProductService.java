package com.example.tao_gio_hang.service;


import com.example.tao_gio_hang.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Iterable<Product> findAll();

    Product findById(Long id);

    void save(Product customer);

    void remove(Long id);
}
