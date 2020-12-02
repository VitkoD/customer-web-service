package com.fabriik.customerwebservice.service;

import com.fabriik.customerwebservice.domain.Customers;
import com.fabriik.customerwebservice.domain.dto.ResponceDto;
import com.fabriik.customerwebservice.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CustomerService {

    @Autowired
    CustomerCache customerCache;


    public void addCustomer(Long id, Integer score) {
        customerCache.putOnCache(id, score);
    }

    public ResponceDto getCustomerById(Long id) {
        Customers customers = customerCache.getOnCache(id).orElse(null);
        if (customers == null) {
            throw new CustomerNotFoundException(id);
        }
        return new ResponceDto(customers.getId(), Double.valueOf(new DecimalFormat("##.##").format(customers.getAverage())));
    }

}
