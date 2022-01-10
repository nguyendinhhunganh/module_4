package com.example.phonemanagement.repository;


import com.example.phonemanagement.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepository extends CrudRepository<Smartphone, Integer> {
}
