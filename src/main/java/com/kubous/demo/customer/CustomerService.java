package com.kubous.demo.customer;

import com.kubous.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService { //Business logic for domain we are working with (Customer)

    //reference to DAO layer
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepository = customerRepo;
    }

    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("customer with id " + id + " not found"));
    }
}
