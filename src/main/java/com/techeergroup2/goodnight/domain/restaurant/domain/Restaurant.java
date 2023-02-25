package com.techeergroup2.goodnight.domain.restaurant.domain;

import com.sun.istack.NotNull;
import com.techeergroup2.goodnight.global.domain.AuditableEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String category;


}
