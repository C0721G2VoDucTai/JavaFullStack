package module_final.exam.service;

import module_final.exam.model.Medical;
import module_final.exam.model.Patient;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

public interface IPatientService {
    Iterable< Patient > findAll();

    Optional< Patient > findById(Integer id);

    void save(Patient patient);

    void remove(Integer id);
}
