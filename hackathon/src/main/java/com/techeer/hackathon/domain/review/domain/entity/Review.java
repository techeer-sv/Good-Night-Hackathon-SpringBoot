package com.techeer.hackathon.domain.review.domain.entity;

import com.techeer.hackathon.domain.restaurant.domain.entity.Restaurant;
import com.techeer.hackathon.domain.review.domain.repository.ReviewRepository;
import com.techeer.hackathon.domain.review.dto.ReviewUpdateRequestDto;
import com.techeer.hackathon.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "review")
@SQLDelete(sql = "UPDATE review SET is_Deleted = true WHERE id = ?")
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 리뷰 제목
    @Column(name = "title", nullable = false)
    private String title;

    // 리뷰 내용
    @Lob //엄청나게 긴 text
    @Column(name = "content", nullable = false)
    private String content;

    // 레스토랑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "is_activated", nullable = false)
    private boolean isActivated;

    @Builder
    public Review(String title, String content, Restaurant restaurant){
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
        this.isActivated = true;
    }

    public void deleteReview() {
        this.isActivated = false;
    }

    public Review updatdReview(ReviewUpdateRequestDto request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        return this;
    }

}
