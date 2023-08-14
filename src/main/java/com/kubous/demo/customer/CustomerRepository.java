package com.kubous.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomerRepository implements CustomerRepo { //class used for connecting to Database
    @Override
    public List<Customer> getCustomers() {
        //TODO connect to real database
        return Collections.emptyList();
    }
}
