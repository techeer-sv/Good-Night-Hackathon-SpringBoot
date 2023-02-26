package com.gilyeon.hackathon.domain.review.entity;

import com.gilyeon.hackathon.domain.restaurant.dto.RestaurantUpdateRequest;
import com.gilyeon.hackathon.domain.restaurant.entity.Restaurant;
import com.gilyeon.hackathon.domain.review.dto.ReviewUpdateRequest;
import com.gilyeon.hackathon.global.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REVIEW")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Builder
    public Review(String title, String content, Restaurant restaurant) {
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
    }

    public void update(ReviewUpdateRequest reviewUpdateRequest){
        this.content = reviewUpdateRequest.getContent();
    }

    public void deleteReview() {
        this.delete();
    }
}