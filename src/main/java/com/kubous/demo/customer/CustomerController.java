package com.kubous.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService cS) {
        this.customerService = cS;
    }

    @GetMapping
    List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

}
