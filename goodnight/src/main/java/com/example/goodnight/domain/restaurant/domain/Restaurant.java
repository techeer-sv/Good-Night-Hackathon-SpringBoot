package com.example.goodnight.domain.restaurant.domain;

import com.example.goodnight.domain.review.domain.Review;
import com.example.goodnight.global.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor

public class Restaurant extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "category")
    private String category;

    @Column(name = "is_activated", nullable = false)
    private boolean isActivated;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews = new ArrayList<>();

    @Builder
    public Restaurant(String restaurantName, String category, List<Review> reviews) {
        this.restaurantName = restaurantName;
        this.category = category;
        this.reviews = reviews;
        this.isActivated = true;
    }

    public void delete() {
        this.isActivated = false;
    }

}
