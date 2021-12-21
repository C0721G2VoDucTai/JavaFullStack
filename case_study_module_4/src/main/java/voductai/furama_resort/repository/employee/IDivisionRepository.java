package voductai.furama_resort.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.furama_resort.model.employee.Division;
@Repository
public interface IDivisionRepository extends JpaRepository< Division, Integer > {
}
