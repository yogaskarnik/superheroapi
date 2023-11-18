package com.wtm.superheroapi.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtm.superheroapi.model.Superhero;
import com.wtm.superheroapi.repository.SuperheroRepository;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SuperheroControllerIntegrationTest {
    Long supermanId;
    Long ironmanId;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SuperheroRepository superheroRepository;

    @BeforeEach
    public void setupTestData() {
        superheroRepository.deleteAll();

        Superhero spiderman = new Superhero("Spiderman");
        superheroRepository.save(spiderman);
        supermanId = spiderman.getId();

        Superhero ironman = new Superhero("Ironman");
        superheroRepository.save(ironman);
        ironmanId = ironman.getId();
    }

    @AfterEach
    public void cleanup() {
        superheroRepository.deleteAll();
    }

    @Test
    public void whenGetAllSuperheros_thenStatus200() throws Exception {
        mockMvc.perform(get("/superheros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void whenGetSuperheroById_thenStatus200() throws Exception {
        mockMvc.perform(get("/superheros/" + ironmanId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.superHeroname").value("Ironman"));
    }

    @Test
    public void whenGetNonExistingSuperheroById_thenStatus404() throws Exception {
        long nonExistingId = 999L;
        mockMvc.perform(get("/superheros/" + nonExistingId))
                .andExpect(status().isNotFound());
    }

    @Test
    public void whenUpdateSuperhero_thenSuperheroUpdated() throws Exception {
        Superhero updatedSuperHero = new Superhero("Amazing Spiderman");
        String updatedSuperheroJSON = new ObjectMapper().writeValueAsString(updatedSuperHero);

        mockMvc.perform(post("/superheros/" + supermanId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedSuperheroJSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.superHeroname").value("Amazing Spiderman"));
    }

    @Test
    public void whenDeleteSuperhero_thenSuperheroDeleted() throws Exception {
        mockMvc.perform(delete("/superheros/" + ironmanId))
                .andExpect(status().isOk());
    }

}
