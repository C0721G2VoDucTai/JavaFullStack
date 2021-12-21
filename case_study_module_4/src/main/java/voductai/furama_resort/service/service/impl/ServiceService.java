package voductai.furama_resort.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import voductai.furama_resort.model.service.Services;
import voductai.furama_resort.repository.service.IServiceRepository;
import voductai.furama_resort.service.service.IServiceService;

import java.util.Optional;

@Component
public class ServiceService implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;

    @Override
    public Iterable< Services > findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional< Services > findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Page< Services > findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Optional< Services > findById(String id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void remove(String id) {
        serviceRepository.findById(id);
    }

    @Override
    public void save(Services services) {
        serviceRepository.save(services);
    }

    @Override
    public void remove(Integer id) {

    }
}
