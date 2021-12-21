package voductai.furama_resort.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import voductai.furama_resort.dto.CustomerUseServiceDTO;
import voductai.furama_resort.model.customer.Customer;
import voductai.furama_resort.service.IGeneralService;

import java.util.Optional;

public interface ICustomerService extends IGeneralService < Customer> {
    Page<Customer> findAll(int page, int size);
    Page<Customer> findCustomerByKeyword(int page, int size, String keyword);
    Page<Customer> findByKeywordAndCustomerType(int page, int size, String keyword, Integer customerTypeId);
    Page<Customer> searchByName(String name, Pageable pageable);
    Page< CustomerUseServiceDTO > listCustomerUsingService(Pageable pageable);
    Optional<Customer> findById(String id);
    void remove(String id);
}
