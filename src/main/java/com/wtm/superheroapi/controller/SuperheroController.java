package com.wtm.superheroapi.controller;

import com.wtm.superheroapi.model.Superhero;
import com.wtm.superheroapi.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/superheros")
public class SuperheroController {

    private final SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Superhero> getSuperheroById(@PathVariable Long id) {
        return superheroService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
