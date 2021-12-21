package voductai.furama_resort.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.furama_resort.model.employee.Role;

import javax.persistence.criteria.CriteriaBuilder;
@Repository
public interface IRoleRepository extends JpaRepository< Role, Integer > {
}
