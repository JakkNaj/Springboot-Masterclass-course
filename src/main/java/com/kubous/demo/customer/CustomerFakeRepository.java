package com.kubous.demo.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "James Bond", "123", "email@gmail.com"),
                new Customer(2l, "Kubous Najman", "123kuba", "email@gmail.com")
        );
    }
}
