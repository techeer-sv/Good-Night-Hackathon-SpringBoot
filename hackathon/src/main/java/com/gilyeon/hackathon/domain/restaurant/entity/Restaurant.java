package com.gilyeon.hackathon.domain.restaurant.entity;

import com.gilyeon.hackathon.domain.restaurant.dto.RestaurantUpdateRequest;
import com.gilyeon.hackathon.domain.review.entity.Review;
import com.gilyeon.hackathon.global.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "RESTAURANT")
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private Long id;

//    @Column(nullable = false, unique = true)
    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private RestaurantCategory category;

//    @OneToMany(mappedBy = "restaurant")
//    @Builder.Default
//    private List<Review> reviewList = new ArrayList<>();

    @Builder
    public Restaurant(String name, RestaurantCategory category) {
        this.name = name;
        this.category = category;
    }

    public void update(RestaurantUpdateRequest restaurantUpdateRequest){
        this.category = restaurantUpdateRequest.getCategory();
    }

    public void deleteRestaurant() {
        this.delete();
    }
}