package com.kubous.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private  CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer jamila = new Customer(1L, "jamila","1234", "jam@gmail.com");
        Customer kubous = new Customer(2L, "kubous","12114", "jakub@gmail.com");
        customerRepository.saveAll(Arrays.asList(jamila,kubous));
        List<Customer> customers = underTest.getCustomers();

        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        Customer jamila = new Customer(1L, "jamila","1234", "jam@gmail.com");
        customerRepository.save(jamila);
        Customer actual = underTest.getCustomer(1L);

        assertEquals(1L, actual.getId());
        assertEquals("jamila", actual.getName());
        //we can test other fields of customer the same way
    }
}