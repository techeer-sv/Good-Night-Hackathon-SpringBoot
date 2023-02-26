package com.techeer.hackathon.domain.restaurant.domain.entity;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponseDto;
import com.techeer.hackathon.domain.review.domain.entity.Review;
import com.techeer.hackathon.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //레스토랑 명
    @Column(name = "name", nullable = false)
    private String name;

    //카테고리
    @Column(name = "category", nullable = false)
    private String category;

    //soft delete
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> restaurantReviews = new ArrayList<>();

    @Builder
    public Restaurant(String name, String category) {
        this.name = name;
        this.category = category;
        this.isDeleted = false;
    }

    //soft delete
    public void deleteBoard() {
        this.isDeleted = true;
    }
}
