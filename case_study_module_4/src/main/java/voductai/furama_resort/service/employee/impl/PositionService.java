package voductai.furama_resort.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voductai.furama_resort.model.employee.Position;
import voductai.furama_resort.repository.employee.IPositionRepository;
import voductai.furama_resort.service.employee.IPositionService;

import java.util.Optional;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository positionRepository;
    @Override
    public Iterable< Position > findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional< Position > findById(Integer id) {
        return positionRepository.findById(id);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void remove(Integer id) {
        positionRepository.deleteById(id);
    }
}
