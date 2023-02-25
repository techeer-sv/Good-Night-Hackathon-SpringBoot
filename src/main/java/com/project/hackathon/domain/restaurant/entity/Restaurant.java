package com.project.hackathon.domain.restaurant.entity;

import com.project.hackathon.domain.review.entity.Review;
import com.project.hackathon.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant")
public class Restaurant extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    // 레스토랑명
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL) // (1)
    @JoinColumn(name="title")
    private ArrayList<Review> title = new ArrayList<>();

    // 레스토랑 카테고리
    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    // 음식점 생성일자
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved;


    @Builder
    public Restaurant(
            ArrayList title,
            Category category,
            LocalDateTime createdAt) {
        this.title = title;
        this.category = category;
        this.createdAt = createdAt;
        this.isRemoved = false;
    }

    public void deleteRestaurant() { //soft delete
        this.isRemoved = true;
    }

}