package com.fabriik.customerwebservice.web;

import com.fabriik.customerwebservice.domain.dto.ResponceDto;
import com.fabriik.customerwebservice.exception.CustomerNotFoundException;
import com.fabriik.customerwebservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer-average-score/{id}")
    ResponceDto getAverageByCustomerId(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @ExceptionHandler({ CustomerNotFoundException.class })
    public ResponseEntity<?> handleException(CustomerNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
