package voductai.furama_resort.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.furama_resort.model.customer.CustomerType;

@Repository
public interface ICustomerTypeRepository extends JpaRepository< CustomerType, Integer > {
}
