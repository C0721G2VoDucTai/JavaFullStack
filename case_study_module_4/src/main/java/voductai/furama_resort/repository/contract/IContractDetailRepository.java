package voductai.furama_resort.repository.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.furama_resort.model.contract.ContractDetail;
@Repository
public interface IContractDetailRepository extends JpaRepository< ContractDetail, Integer > {
}
