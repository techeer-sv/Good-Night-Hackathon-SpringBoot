package com.project.hackathon.domain.review.entity;

import com.project.hackathon.domain.restaurant.entity.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class Review{

    @Id // 이 멤버변수는 primary key라는 것을 나타내며 없으면 에러남
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id를 autoincrement로 설정
    private Long id;

    // 리뷰 제목
    @Column(name = "title", nullable = false)
    private String title;

    // 리뷰 내용
    @Lob // 엄청나게 긴 text
    @Column(name = "content", nullable = false)
    private String content;

    // 특정 레스토랑명
    @Column(name = "restaurant", nullable = false)
    private String restaurant;

    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved;

    @Builder
    public Review(
            String title,
            String content,
            String restaurant) {
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
        this.isRemoved = false;
    }

    public void deleteRestaurant() { //soft delete
        this.isRemoved = true;
    }

}