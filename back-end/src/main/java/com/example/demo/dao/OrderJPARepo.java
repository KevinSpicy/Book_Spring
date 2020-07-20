package com.example.demo.dao;

import com.example.demo.model.Order;
import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;


public interface OrderJPARepo extends CrudRepository<Order, Long> {
    Iterable<Order> findByUserOrderByPlacedAtDesc(User user);
}
