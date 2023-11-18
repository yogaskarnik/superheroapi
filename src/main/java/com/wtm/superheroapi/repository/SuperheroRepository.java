package com.wtm.superheroapi.repository;

import com.wtm.superheroapi.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
    List<Superhero> findBySuperHeronameContaining(String searchTerm);
}
