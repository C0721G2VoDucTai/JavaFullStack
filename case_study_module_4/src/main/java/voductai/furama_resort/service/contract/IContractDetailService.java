package voductai.furama_resort.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import voductai.furama_resort.model.contract.ContractDetail;
import voductai.furama_resort.service.IGeneralService;

public interface IContractDetailService extends IGeneralService< ContractDetail > {
    Page<ContractDetail> findAll(Pageable pageable);
}
