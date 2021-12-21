package voductai.furama_resort.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.furama_resort.model.employee.User;
@Repository
public interface IUserRepository extends JpaRepository< User, Integer > {
    User findByName(String userName);
}
