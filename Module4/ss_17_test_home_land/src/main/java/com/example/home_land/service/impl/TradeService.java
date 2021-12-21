package com.example.home_land.service.impl;

import com.example.home_land.model.Customer;
import com.example.home_land.model.Trade;
import com.example.home_land.repository.ITradeRepository;
import com.example.home_land.service.ITradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TradeService implements ITradeService {
    @Autowired
    private ITradeRepository tradeRepository;

    @Override
    public Page< Trade > findByCustomerName(String name, Pageable pageable) {
        return tradeRepository.findAllByCustomerName(name, pageable);
    }

    @Override
    public Page< Trade > findByServiceType(String serviceType, Pageable pageable) {
        return tradeRepository.findAllByServiceTypeContaining(serviceType,pageable);
    }

    @Override
    public Page< Trade > findAll(Pageable pageable) {
        return tradeRepository.findAll(pageable);
    }

//    @Override
//    public Page< Trade > findByCustomerId(Integer customerId, Pageable pageable) {
//        return tradeRepository.findAllByCustomer_Id(customerId, pageable);
//    }

    @Override
    public Page< Trade > findByCustomerNameAndService(String serviceType, String name, Pageable pageable) {
        return tradeRepository.findAllByCustomerNameAndServiceType(serviceType,name,pageable);
    }

    @Override
    public Iterable< Trade > findAll() {
        return tradeRepository.findAll();
    }

    @Override
    public Optional< Trade > findById(String id) {
        return tradeRepository.findById(id);
    }

    @Override
    public void save(Trade trade) {
        tradeRepository.save(trade);
    }

    @Override
    public void remove(String id) {
        tradeRepository.deleteById(id);
    }
}
