package com.example.dartpracticalexam.controllers;

import com.example.dartpracticalexam.entity.Customer;
import com.example.dartpracticalexam.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerRepo customerRepo;
    @Autowired
    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("/get-list-customers")
    public ResponseEntity<List<Customer>> getAllEmployees() {
        List<Customer> customers = customerRepo.findAll();
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/save-new-customer")
    public ResponseEntity<Customer> createEmployee(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepo.save(customer);
        return ResponseEntity.ok(savedCustomer);
    }
}