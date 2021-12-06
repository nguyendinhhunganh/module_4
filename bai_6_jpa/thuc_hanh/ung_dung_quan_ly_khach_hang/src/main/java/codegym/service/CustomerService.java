package codegym.service;

import codegym.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);

//    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
