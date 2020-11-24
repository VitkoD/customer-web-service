package com.fabriik.customerwebservice.service;

import com.fabriik.customerwebservice.domain.dto.CountAndAverageDto;
import com.fabriik.customerwebservice.domain.dto.ResponceDto;
import com.fabriik.customerwebservice.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class CustomerService {

    Map<Long, CountAndAverageDto> customers = new HashMap<>();

    public void addCustomerAndCountAverage(Long id, Integer score) {
        CountAndAverageDto countAndAverage = customers.get(id);
        if (countAndAverage == null) {
            customers.put(id, new CountAndAverageDto(1L, Double.valueOf(score)));
        } else {
            Long oldCount = countAndAverage.getCount();
            Double oldAverage = countAndAverage.getAverage();
            Double averageNow = oldAverage * oldCount;
            countAndAverage.setCount(oldCount + 1);
            countAndAverage.setAverage((averageNow + score) / (oldCount + 1));
            customers.put(id, countAndAverage);
        }
    }

    public ResponceDto getCustomerById(Long id) {
        CountAndAverageDto countAndAverage = customers.get(id);
        if (countAndAverage == null) {
            throw new CustomerNotFoundException(id);
        }
        return new ResponceDto(id, Double.valueOf(new DecimalFormat("##.##").format(countAndAverage.getAverage())));
    }

}
