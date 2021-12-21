package voductai.furama_resort.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voductai.furama_resort.model.employee.EducationDegree;
import voductai.furama_resort.repository.employee.IEducationDegreeRepository;
import voductai.furama_resort.service.employee.IEducationDegreeService;

import java.util.Optional;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    IEducationDegreeRepository educationDegreeRepository;

    @Override
    public Iterable< EducationDegree > findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Optional< EducationDegree > findById(Integer id) {
        return educationDegreeRepository.findById(id);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void remove(Integer id) {
        educationDegreeRepository.deleteById(id);
    }
}
