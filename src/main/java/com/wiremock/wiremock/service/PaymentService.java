package com.wiremock.wiremock.service;

import com.wiremock.wiremock.di.OrderRepository;
import com.wiremock.wiremock.impl.OrderImplB;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service

public class PaymentService  {

    @Autowired
   // @Qualifier("orderImplB")
    @Resource(name = "orderImplA")
    private OrderRepository orderRepository;
    @Autowired
    // @Qualifier("orderImplB")
    @Resource(name = "orderImplB")
    private OrderRepository orderRepository2;
    private final RestTemplate restTemplate;

    public PaymentService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String processPayment() {
        orderRepository.saveOrder();
        orderRepository2.saveOrder();
        try {
            return restTemplate.getForObject("http://localhost:8081/api/payment", String.class);
        } catch (ResourceAccessException ex) {
            return "Payment service is unavailable.";
        }
    }


}
