package com.project.hackathon.domain.restaurant.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant")
public class Restaurant{

    @Id // 이 멤버변수는 primary key라는 것을 나타내며 없으면 에러남
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id를 autoincrement로 설정
    private Long id;

    // 레스토랑 명
    @Column(name = "title", nullable = false)
    private String title;

    // 레스토랑 카테고리
    @Column(name = "restaurant_category", nullable = false)
    @Enumerated(EnumType.STRING)
    private RestaurantCategory restaurantCategory;

    // 음식점 생성일자
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved;


    @Builder
    public Restaurant(
            String title,
            RestaurantCategory restaurantCategory,
            LocalDateTime createdAt) {
        this.title = title;
        this.restaurantCategory = restaurantCategory;
        this.createdAt = createdAt;
        this.isRemoved = false;
    }

    public void deleteRestaurant() { //soft delete
        this.isRemoved = true;
    }

}