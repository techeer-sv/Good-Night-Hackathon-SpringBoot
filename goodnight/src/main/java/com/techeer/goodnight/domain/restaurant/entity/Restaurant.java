package com.techeer.goodnight.domain.restaurant.entity;
import com.techeer.goodnight.domain.review.entity.Review;
import lombok.*;
import com.techeer.goodnight.global.domain.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Table(name = "restaurant")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String categoryName;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    @NonNull
    private List<Review> reviewList = new ArrayList<>();


    @Builder
    public Restaurant(String name, String categoryName) {
        this.name = name;
        this.categoryName = categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

}