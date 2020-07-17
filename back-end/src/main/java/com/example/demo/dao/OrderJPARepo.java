package com.example.demo.dao;

import com.example.demo.model.Order;
import com.example.demo.model.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderJPARepo extends CrudRepository<Order, Long> {
    List<Order> findByUserOrderByPlacedAtDesc(User user);
}
