package com.project.hackathon.domain.review.entity;

import com.project.hackathon.global.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    // 리뷰 제목
    @Column(name = "title", nullable = false)
    private String title;

    // 리뷰 내용
    @Lob // 엄청나게 긴 text
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "restaurant", nullable = false)
    private String restaurant;

    @CreationTimestamp
    @Column(name = "createdAt")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved;

    @Builder
    public Review(
            String title,
            String content,
            String restaurant){
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
        this.isRemoved = false;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
    public void deleteReview() { //soft delete
        this.isRemoved = true;
    }

}