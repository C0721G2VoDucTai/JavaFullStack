package voductai.furama_resort.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voductai.furama_resort.model.customer.CustomerType;
import voductai.furama_resort.repository.customer.ICustomerTypeRepository;
import voductai.furama_resort.service.customer.ICustomerTypeService;

import java.util.Optional;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public Iterable< CustomerType > findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Optional< CustomerType > findById(Integer id) {
        return customerTypeRepository.findById(id);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void remove(Integer id) {
        customerTypeRepository.deleteById(id);
    }
}
