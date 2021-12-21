package voductai.furama_resort.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.furama_resort.model.service.RentalType;
@Repository
public interface IRentalTypeRepository extends JpaRepository< RentalType, Integer > {
}
