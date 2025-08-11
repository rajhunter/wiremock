package com.wiremock.wiremock.impl;

import com.wiremock.wiremock.di.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderImplA implements OrderRepository {
    @Override
    public void saveOrder() {
        System.out.println("*****************************");

        System.out.println("OrderImplA");
        System.out.println("*****************************");

    }
}
