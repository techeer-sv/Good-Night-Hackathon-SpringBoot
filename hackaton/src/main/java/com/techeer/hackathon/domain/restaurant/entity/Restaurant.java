package com.techeer.hackathon.domain.restaurant.entity;

import com.techeer.hackathon.domain.review.entity.Review;
import com.techeer.hackathon.global.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private RestaurantCategory category;

    @OneToMany(mappedBy = "restaurant")
    @Builder.Default
    private List<Review> reviewList = new ArrayList<>();

    @Builder
    public Restaurant(String name, RestaurantCategory category) {
        this.name = name;
        this.category = category;
    }
}
