package com.example.dartpracticalexam.services.Impl;

import com.example.dartpracticalexam.entity.Customer;
import com.example.dartpracticalexam.repositories.CustomerRepo;
import com.example.dartpracticalexam.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> getAllEmployees() {
        return customerRepo.findAll();
    }

    @Override
    public void addEmployee(Customer customer) {
        if(ObjectUtils.isEmpty(customer)){
            throw new NullPointerException("Student data is invalid");
        }
        customerRepo.save(customer);
    }

}
