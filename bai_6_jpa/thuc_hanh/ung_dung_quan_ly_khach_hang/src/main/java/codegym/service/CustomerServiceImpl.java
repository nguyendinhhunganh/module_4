package codegym.service;

import codegym.model.Customer;
import codegym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService{


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

//    @Override
//    public Iterable<Customer> findAllByProvince(Province province) {
//        return customerRepository.findAllByProvince(province);
//    }
//
//    @Override
//    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
//        return customerRepository.findAllByFirstNameContaining(firstname, pageable);
//    }
}
