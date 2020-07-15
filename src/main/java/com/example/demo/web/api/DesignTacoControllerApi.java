package com.example.demo.web.api;

import com.example.demo.dao.TacoJPARepo;
import com.example.demo.model.Taco;
import com.example.demo.properties.TacoProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/design", produces = "application/json")
public class DesignTacoControllerApi {
    private TacoJPARepo tacoJPARepo;
    private TacoProps tacoProps;

    @Autowired
    public DesignTacoControllerApi(TacoJPARepo tacoJPARepo, TacoProps tacoProps) {
        this.tacoJPARepo = tacoJPARepo;
        this.tacoProps = tacoProps;
    }

    @GetMapping("/recent")
    public Iterable<Taco> recentTacos() {
        return tacoJPARepo.findAllByOrderByCreatedAtDesc()
                .stream()
                    .limit(tacoProps.getRecentTacoSize())
                        .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> taco = tacoJPARepo.findById(id);
        if (taco.isPresent()) {
            return new ResponseEntity<>(taco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoJPARepo.save(taco);
    }
}
