package voductai.phone_management.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.phone_management.model.Smartphone;
@Repository
public interface ISmartphoneRepository extends JpaRepository< Smartphone, Long > {

}
