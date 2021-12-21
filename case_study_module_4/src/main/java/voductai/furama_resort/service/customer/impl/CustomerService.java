package voductai.furama_resort.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import voductai.furama_resort.dto.CustomerUseServiceDTO;
import voductai.furama_resort.model.customer.Customer;
import voductai.furama_resort.repository.customer.ICustomerRepository;
import voductai.furama_resort.service.customer.ICustomerService;

import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Iterable< Customer > findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional< Customer > findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void remove(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page< Customer > findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page< Customer > findCustomerByKeyword(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page,size);
        return customerRepository.findCustomerByKeyword(keyword,pageable);
    }

    @Override
    public Page< Customer > findByKeywordAndCustomerType(int page, int size,String keyword, Integer customerTypeId) {
        Pageable pageable = PageRequest.of(page,size);
        return customerRepository.findByKeywordAAndCustomerType(keyword,customerTypeId,pageable);
    }

    @Override
    public Page< Customer > searchByName(String name, Pageable pageable) {
        return customerRepository.searchByName(name, pageable);
    }

    @Override
    public Page< CustomerUseServiceDTO > listCustomerUsingService(Pageable pageable) {
        return customerRepository.listCustomerUsingService(pageable);
    }

    @Override
    public Optional< Customer > findById(Integer id) {
        return Optional.empty();
    }
    @Override
    public void remove(Integer id) {

    }
}
