package module_final.exam.service.impl;

import module_final.exam.model.Patient;
import module_final.exam.repository.IPatientRepository;
import module_final.exam.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PatientService implements IPatientService {
    @Autowired
    private IPatientRepository patientRepository;
    @Override
    public Iterable< Patient > findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional< Patient > findById(Integer id) {
        return patientRepository.findById(id);
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void remove(Integer id) {
        patientRepository.deleteById(id);
    }
}
