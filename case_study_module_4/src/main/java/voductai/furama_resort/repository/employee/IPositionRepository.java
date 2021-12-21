package voductai.furama_resort.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.furama_resort.model.employee.Position;
@Repository
public interface IPositionRepository extends JpaRepository< Position, Integer > {

}
