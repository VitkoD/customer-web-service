package com.fabriik.customerwebservice.service;

import com.fabriik.customerwebservice.domain.Customer;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class Listener {

    @Autowired
    private CustomerService customerService;

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void MessageListener(byte[] message) {
        try {
            Customer.customer customer = Customer.customer.parseFrom(message);
            customerService.addCustomerAndCountAverage(customer.getId(), customer.getScore());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
