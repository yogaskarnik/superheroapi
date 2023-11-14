package com.wtm.superheroapi.service;

import com.wtm.superheroapi.model.Superhero;
import com.wtm.superheroapi.repository.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroService {
    private final SuperheroRepository superherRepository;

    @Autowired
    public SuperheroService(SuperheroRepository superheroRepository){
        this.superherRepository = superheroRepository;
    }

    public List<Superhero> findAll(){
        return superherRepository.findAll();
    }
}
