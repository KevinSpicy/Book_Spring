package com.example.demo.dao;

import com.example.demo.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoJPARepo extends CrudRepository<Taco, Long> {
    Iterable<Taco> findAllByOrderByCreatedAtDesc();
}
