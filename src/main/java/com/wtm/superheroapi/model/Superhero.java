package com.wtm.superheroapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "superhero")
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "super_hero_name")
    private String superHeroname;

    public Superhero() {
    }

    public Superhero(String superHeroName) {
        this.superHeroname = superHeroName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuperHeroname() {
        return superHeroname;
    }

    public void setSuperHeroname(String superHeroname) {
        this.superHeroname = superHeroname;
    }
}
