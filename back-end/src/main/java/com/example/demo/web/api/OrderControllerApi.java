package com.example.demo.web.api;

import com.example.demo.dao.OrderJPARepo;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order", produces = "application/json")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderControllerApi {

    @Autowired
    private OrderJPARepo orderJPARepo;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Order postOrder(@RequestBody Order order) {
        return orderJPARepo.save(order);
    }
}
