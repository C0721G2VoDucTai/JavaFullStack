package voductai.furama_resort.service.contract.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import voductai.furama_resort.model.contract.ContractDetail;
import voductai.furama_resort.repository.contract.IContractDetailRepository;
import voductai.furama_resort.service.contract.IContractDetailService;

import java.util.Optional;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;
    @Override
    public Iterable< ContractDetail > findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Optional< ContractDetail > findById(Integer id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Integer id) {
        contractDetailRepository.deleteById(id);
    }


    @Override
    public Page< ContractDetail > findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }
}
