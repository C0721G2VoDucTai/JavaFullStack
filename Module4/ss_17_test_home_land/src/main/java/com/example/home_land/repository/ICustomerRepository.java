package com.example.home_land.repository;

import com.example.home_land.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository < Customer, Integer> {
}
