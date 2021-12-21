package voductai.furama_resort.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voductai.furama_resort.model.employee.Division;
import voductai.furama_resort.repository.employee.IDivisionRepository;
import voductai.furama_resort.service.employee.IDivisionService;

import java.util.Optional;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;

    @Override
    public Iterable< Division > findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Optional< Division > findById(Integer id) {
        return divisionRepository.findById(id);
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void remove(Integer id) {
        divisionRepository.deleteById(id);
    }
}
