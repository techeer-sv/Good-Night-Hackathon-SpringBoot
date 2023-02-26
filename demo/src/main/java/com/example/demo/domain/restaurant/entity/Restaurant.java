package com.example.demo.domain.restaurant.entity;

import com.example.demo.domain.review.entity.Review;
import com.example.demo.global.entity.TimeEntity;
import com.example.demo.global.enumpkg.Category;
import com.example.demo.domain.restaurant.dto.request.RestaurantUpdateRequest;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Restaurant extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted = Boolean.FALSE;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviewList;

    @Builder
    public Restaurant(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public void update(RestaurantUpdateRequest restaurantUpdateRequest){
        this.category = restaurantUpdateRequest.getCategory();
    }
}
