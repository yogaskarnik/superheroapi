package com.wtm.superheroapi.controller;

import com.wtm.superheroapi.model.Superhero;
import com.wtm.superheroapi.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superheros")
public class SuperheroController {

    private final SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping
    public ResponseEntity<List<Superhero>> getAll() {
        List<Superhero> superheros = superheroService.findAll();
        return ResponseEntity.ok(superheros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Superhero> getSuperheroById(@PathVariable Long id) {
        return superheroService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Superhero> updateSuperhero(@PathVariable Long id, @RequestBody Superhero superhero) {
        return superheroService.updateSuperhero(id, superhero)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Superhero> deleteSuperhero(@PathVariable Long id) {
        superheroService.deleteSuperhero(id);
        return ResponseEntity.ok().build();
    }


}
