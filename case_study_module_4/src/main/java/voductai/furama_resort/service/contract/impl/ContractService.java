package voductai.furama_resort.service.contract.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import voductai.furama_resort.model.contract.Contract;
import voductai.furama_resort.repository.contract.IContractRepository;
import voductai.furama_resort.service.contract.IContractService;

import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;

    @Override
    public Iterable< Contract > findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Optional< Contract > findById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page< Contract > findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }
}
