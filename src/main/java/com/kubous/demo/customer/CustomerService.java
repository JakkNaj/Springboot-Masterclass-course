package com.kubous.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService { //Business logic for domain we are working with (Customer)

    //referance to DAO layer
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomer() {
        return customerRepo.getCustomers();
    }
}
