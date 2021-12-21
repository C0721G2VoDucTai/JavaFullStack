package com.example.home_land.service.impl;

import com.example.home_land.model.Customer;
import com.example.home_land.repository.ICustomerRepository;
import com.example.home_land.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Iterable< Customer > findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional< Customer > findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remove(Integer id) {

    }
}
