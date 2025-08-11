package com.wiremock.wiremock.impl;

import com.wiremock.wiremock.di.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderImplB  implements OrderRepository {
    @Override
    public void saveOrder() {
        System.out.println("*****************************");
        System.out.println("OrderImplB");
        System.out.println("*****************************");
    }
}