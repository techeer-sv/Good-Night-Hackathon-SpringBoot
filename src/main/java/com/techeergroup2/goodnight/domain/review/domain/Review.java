package com.techeergroup2.goodnight.domain.review.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.techeergroup2.goodnight.domain.restaurant.domain.Restaurant;
import com.techeergroup2.goodnight.domain.review.dto.ReviewCreateResponse;
import com.techeergroup2.goodnight.global.domain.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Review extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;



    public ReviewCreateResponse toResponse() {
        return ReviewCreateResponse.builder()
                .title(title)
                .content(content)
                .build();
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}
