package com.example.demo.domain.restaurant.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class Restaurant {

    @Id
    private Long id;
    private String name;
    

}
