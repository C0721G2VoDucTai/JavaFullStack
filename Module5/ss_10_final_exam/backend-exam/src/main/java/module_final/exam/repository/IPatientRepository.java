package module_final.exam.repository;

import module_final.exam.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository< Patient, Integer > {

}
