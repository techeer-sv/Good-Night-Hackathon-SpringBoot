package com.example.hackathon.restaurant.domain.entity;

import com.example.hackathon.global.entity.BaseTimeEntity;
import com.example.hackathon.review.domain.entity.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "restaurant")
@NoArgsConstructor
public class Restaurant extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id" , nullable = false)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews;

    public void deleteRestaurant() { this.activeOff(); }
}
