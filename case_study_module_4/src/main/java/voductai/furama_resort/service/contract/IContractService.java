package voductai.furama_resort.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import voductai.furama_resort.model.contract.Contract;
import voductai.furama_resort.service.IGeneralService;

public interface IContractService extends IGeneralService< Contract > {
    public Page<Contract> findAll(Pageable pageable);
}
