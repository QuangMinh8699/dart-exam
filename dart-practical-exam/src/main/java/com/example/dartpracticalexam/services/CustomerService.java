package com.example.dartpracticalexam.services;

import com.example.dartpracticalexam.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllEmployees();

    void addEmployee(Customer customer);

}
