package voductai.furama_resort.service.contract.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voductai.furama_resort.model.contract.AttachService;
import voductai.furama_resort.repository.contract.IAttachServiceRepository;
import voductai.furama_resort.repository.contract.IContractDetailRepository;
import voductai.furama_resort.service.contract.IAttachServiceService;

import java.util.Optional;
@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    IAttachServiceRepository attachServiceRepository;
    @Override
    public Iterable< AttachService > findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Optional< AttachService > findById(Integer id) {
        return attachServiceRepository.findById(id);
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Integer id) {
        attachServiceRepository.deleteById(id);
    }
}
