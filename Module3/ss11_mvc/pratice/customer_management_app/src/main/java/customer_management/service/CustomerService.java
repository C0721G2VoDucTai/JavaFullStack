package customer_management.service;

import customer_management.model.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    void update(int id, Customer customer);

    void remove(int id);

    Customer findById(int id);

    List< Customer > findAll();
}
