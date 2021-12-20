package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}