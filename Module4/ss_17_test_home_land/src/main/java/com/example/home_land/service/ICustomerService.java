package com.example.home_land.service;

import com.example.home_land.model.Customer;

import java.util.Optional;
public interface ICustomerService {
    Iterable< Customer > findAll();

    Optional<Customer> findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);
}
