package com.example.demo.web.api;

import com.example.demo.dao.TacoJPARepo;
import com.example.demo.model.Taco;
import com.example.demo.properties.TacoProps;
import com.example.demo.web.api.resource.TacoResource;
import com.example.demo.web.api.resource.resourceassembler.TacoResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "http://localhost:4200")
public class DesignTacoControllerApi {

    private TacoJPARepo tacoJPARepo;
    private TacoProps tacoProps;

    @Autowired
    public DesignTacoControllerApi(TacoJPARepo tacoJPARepo, TacoProps tacoProps) {
        this.tacoJPARepo = tacoJPARepo;
        this.tacoProps = tacoProps;
    }

    @GetMapping("/recent")
    public CollectionModel<TacoResource> recentTacos() {
        List<Taco> recentTacos = ((List<Taco>)tacoJPARepo.findAllByOrderByCreatedAtDesc())
                                                            .stream()
                                                                .limit(tacoProps.getRecentTacoSize())
                                                                    .collect(Collectors.toList());
        CollectionModel<TacoResource> tacoResources = new TacoResourceAssembler().toCollectionModel(recentTacos);
        tacoResources.add(ControllerLinkBuilder.linkTo(
                            ControllerLinkBuilder.methodOn(DesignTacoControllerApi.class)
                                                    .recentTacos())
                                                    .withRel("recents"));
        return tacoResources;
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
