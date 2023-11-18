package com.wtm.superheroapi.service;

import com.wtm.superheroapi.model.Superhero;
import com.wtm.superheroapi.repository.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperheroService {
    private final SuperheroRepository superheroRepository;

    @Autowired
    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    public List<Superhero> findAll() {
        return superheroRepository.findAll();
    }

    public Superhero createSuperhero(Superhero superhero) {
        return superheroRepository.save(superhero);
    }

    public Optional<Superhero> findById(Long id) {
        return superheroRepository.findById(id);
    }

    public Optional<Superhero> updateSuperhero(Long id, Superhero updatedSuperhero) {
        return superheroRepository.findById(id)
                .map(superhero -> {
                    superhero.setSuperHeroname(updatedSuperhero.getSuperHeroname());
                    return superheroRepository.save(superhero);
                });
    }

    public void deleteSuperhero(Long id) {
        superheroRepository.deleteById(id);
    }

}
