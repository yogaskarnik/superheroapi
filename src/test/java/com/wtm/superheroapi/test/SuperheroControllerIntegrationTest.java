package com.wtm.superheroapi.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SuperheroControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenGetSuperheroById_thenStatus200() throws Exception {
        mockMvc.perform(get("/superheros/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Batman"));
    }

}
