package com.kubous.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService { //Business logic for domain we are working with (Customer)

    //reference to DAO layer
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }

    Customer getCustomer(Long id) {
        return getCustomers()
                .stream().filter(customer -> customer.getId().equals(id))
                .findFirst().orElseThrow(() -> new IllegalStateException("customer not found"));
    }
}
