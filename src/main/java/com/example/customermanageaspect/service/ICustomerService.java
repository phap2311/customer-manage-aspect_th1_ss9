package com.example.customermanageaspect.service;

import com.example.customermanageaspect.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {



    Iterable<Customer>findAll() throws Exception;
    void save(Customer customer);
    Optional<Customer>findById(Long id) throws Exception;
    void remove(Long id);

}
