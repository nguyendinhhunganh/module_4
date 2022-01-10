package com.example.phonemanagement.service;


import com.example.phonemanagement.model.Smartphone;
import org.springframework.stereotype.Service;

@Service
public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone phone);
    Smartphone remove(Integer id);
}