package com.kubous.demo.customer;

import com.kubous.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService { //Business logic for domain we are working with (Customer)

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    //reference to DAO layer
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepository = customerRepo;
    }



    List<Customer> getCustomers() {
        LOGGER.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException = new NotFoundException("customer with id " + id + " not found");
                            LOGGER.error("error in getCustomer id:{}", id, notFoundException);
                            return notFoundException;
                        });
    }
}
