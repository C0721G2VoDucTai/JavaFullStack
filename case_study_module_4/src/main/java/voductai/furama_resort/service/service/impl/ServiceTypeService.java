package voductai.furama_resort.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voductai.furama_resort.model.service.ServiceType;
import voductai.furama_resort.repository.service.IServiceTypeRepository;
import voductai.furama_resort.service.service.IServiceTypeService;

import java.util.Optional;
@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;
    @Override
    public Iterable< ServiceType > findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Optional< ServiceType > findById(Integer id) {
        return serviceTypeRepository.findById(id);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void remove(Integer id) {
        serviceTypeRepository.deleteById(id);
    }
}
