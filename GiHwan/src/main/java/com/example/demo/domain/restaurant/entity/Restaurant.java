package com.example.demo.domain.restaurant.entity;

import com.example.demo.domain.restaurant.dto.RestaurantCreateRequest;
import com.example.demo.domain.restaurant.dto.RestaurantUpdateRequest;
import com.example.demo.domain.restaurant.entity.RestaurantCategory;
import com.example.demo.global.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="restaurant")
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private RestaurantCategory category;

//    @OneToMany(mappedBy = "id")
//    @Builder.Default
//    private List<Review> reviewList = new ArrayList<>();

    @Builder
    public Restaurant(String name, RestaurantCategory category) {
        this.name = name;
        this.category = category;
    }

    public void update(RestaurantCategory category){
        this.category = category;
    }
    public void deleteRestaurant() {
        this.delete();
    }
}
