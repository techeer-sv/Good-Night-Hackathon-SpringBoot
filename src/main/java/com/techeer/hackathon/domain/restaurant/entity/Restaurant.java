package com.techeer.hackathon.domain.restaurant.entity;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantUpdateDto;
import com.techeer.hackathon.global.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="restaurant")
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "name", nullable = false)
    private String name;

    @Builder
    public Restaurant(String category, String name) {
        this.category = category;
        this.name = name;
        this.activated = true;
    }

    public void update(RestaurantUpdateDto restaurantUpdate){
        this.category = restaurantUpdate.getCategory();
    }

    public void delete() { //soft delete
        this.activated = false;
    }
}