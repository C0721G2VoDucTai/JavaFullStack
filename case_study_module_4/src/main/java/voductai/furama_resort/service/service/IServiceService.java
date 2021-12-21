package voductai.furama_resort.service.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import voductai.furama_resort.model.service.Services;
import voductai.furama_resort.service.IGeneralService;

import java.util.Optional;

public interface IServiceService extends IGeneralService< Services > {
    Page<Services> findAll(Pageable pageable);
    Optional< Services > findById(String id);
    void remove(String id);
}
