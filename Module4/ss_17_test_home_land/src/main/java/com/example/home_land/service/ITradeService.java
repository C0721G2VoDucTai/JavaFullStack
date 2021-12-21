package com.example.home_land.service;
import com.example.home_land.model.Trade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ITradeService {
    Page<Trade> findByCustomerName(String name, Pageable pageable);
    Page<Trade> findByServiceType(String serviceType, Pageable pageable);
    Page< Trade > findAll(Pageable pageable);
//    Page<Trade> findByCustomerId(Integer customerId, Pageable pageable);
    Page<Trade> findByCustomerNameAndService(String serviceType, String name, Pageable pageable);


    Iterable< Trade > findAll();

    Optional< Trade > findById(String id);

    void save(Trade trade);

    void remove(String id);
}
