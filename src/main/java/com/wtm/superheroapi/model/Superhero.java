package com.wtm.superheroapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "superhero")
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "super_hero_name")
    private String superHeroName;

    public Superhero() {
    }

    public Superhero(String superHeroName) {
        this.superHeroName = superHeroName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        this.superHeroName = superHeroName;
    }
}
