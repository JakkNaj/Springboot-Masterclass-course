package com.kubous.demo.customer;

import com.kubous.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .findFirst().orElseThrow(() -> new NotFoundException("customer with id " + id + " not found"));
    }
}
