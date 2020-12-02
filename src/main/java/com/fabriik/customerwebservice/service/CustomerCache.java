package com.fabriik.customerwebservice.service;


import com.fabriik.customerwebservice.domain.Customers;
import com.fabriik.customerwebservice.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@CacheConfig(cacheNames = {"customers"})
public class CustomerCache {


    @Autowired
    CustomersRepository customersRepository;

    @Cacheable(key = "#id")
    public Optional<Customers> getOnCache(Long id) {
        return customersRepository.findById(id);
    }


    @CachePut(key = "#id")
    public Customers putOnCache(Long id, Integer score) {
        Customers customer = customersRepository.findById(id).orElse(null);
        if (customer == null) {
            customer = new Customers(id, 1L, Double.valueOf(score));
        } else {
            Long oldCount = customer.getCount();
            Double oldAverage = customer.getAverage();
            Double averageNow = oldAverage * oldCount;
            customer.setCount(oldCount + 1);
            customer.setAverage((averageNow + score) / (oldCount + 1));
        }
        return customersRepository.save(customer);
    }
}
