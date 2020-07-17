package com.example.demo.dao;

import com.example.demo.model.Order;

public interface OrderRepository {

    Order save(Order order);
}
