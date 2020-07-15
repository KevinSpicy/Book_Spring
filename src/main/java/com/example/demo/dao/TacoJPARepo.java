package com.example.demo.dao;

import com.example.demo.model.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TacoJPARepo extends CrudRepository<Taco, Long> {
    List<Taco> findAllByOrderByCreatedAtDesc();
}
