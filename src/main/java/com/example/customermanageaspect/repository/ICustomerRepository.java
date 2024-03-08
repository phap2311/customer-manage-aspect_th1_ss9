package com.example.customermanageaspect.repository;


import com.example.customermanageaspect.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer,Long> {

}
