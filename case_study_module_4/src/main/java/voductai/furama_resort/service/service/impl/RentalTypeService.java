package voductai.furama_resort.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voductai.furama_resort.model.service.RentalType;
import voductai.furama_resort.repository.service.IRentalTypeRepository;
import voductai.furama_resort.service.service.IRentalTypeService;

import java.util.Optional;
@Service
public class RentalTypeService implements IRentalTypeService {
    @Autowired
    IRentalTypeRepository rentalTypeRepository;
    @Override
    public Iterable< RentalType > findAll() {
        return rentalTypeRepository.findAll();
    }

    @Override
    public Optional< RentalType > findById(Integer id) {
        return rentalTypeRepository.findById(id);
    }

    @Override
    public void save(RentalType rentalType) {
        rentalTypeRepository.save(rentalType);
    }

    @Override
    public void remove(Integer id) {
        rentalTypeRepository.deleteById(id);
    }
}
