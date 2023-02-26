package com.techeer.hackathon.domain.review.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.review.dto.ReviewUpdateDto;
import com.techeer.hackathon.global.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="review")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore //json response에서 figure를 제외하고 보내기
    private Restaurant restaurant;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Review(String title, String content, Restaurant restaurant){
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
    }

    public void update(ReviewUpdateDto reviewUpdate) {
        this.title = reviewUpdate.getTitle();
        this.content = reviewUpdate.getContent();
    }
}