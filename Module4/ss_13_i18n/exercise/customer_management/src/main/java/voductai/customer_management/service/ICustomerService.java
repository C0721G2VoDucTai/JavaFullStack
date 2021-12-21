package voductai.customer_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import voductai.customer_management.model.Customer;

public interface ICustomerService  extends IGeneralService< Customer >{
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
