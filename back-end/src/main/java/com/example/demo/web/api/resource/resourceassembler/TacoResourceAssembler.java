package com.example.demo.web.api.resource.resourceassembler;

import com.example.demo.model.Taco;
import com.example.demo.web.api.DesignTacoControllerApi;
import com.example.demo.web.api.resource.TacoResource;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class TacoResourceAssembler extends RepresentationModelAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignTacoControllerApi.class, TacoResource.class);
    }

    @Override
    public TacoResource toModel(Taco entity) {
        return createModelWithId(entity.getId(), entity);
    }

    @Override
    public TacoResource instantiateModel(Taco entity) {
        return new TacoResource(entity);
    }
}
