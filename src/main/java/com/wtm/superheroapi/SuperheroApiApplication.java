package com.wtm.superheroapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SuperheroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperheroApiApplication.class, args);
    }

}
