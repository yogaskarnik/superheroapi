package com.wtm.superheroapi.repository;

import com.wtm.superheroapi.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
}
