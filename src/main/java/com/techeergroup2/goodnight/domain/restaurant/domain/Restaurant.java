package com.techeergroup2.goodnight.domain.restaurant.domain;

import com.sun.istack.NotNull;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantDtoResponse;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantUpdateResponse;
import com.techeergroup2.goodnight.global.domain.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE restaurant SET deleted = true WHERE id=?")
@FilterDef(name = "deletedRestaurantFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedRestaurantFilter", condition = "deleted = :isDeleted")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private boolean deleted = Boolean.FALSE;

    public Restaurant(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;


    @Builder
    public RestaurantDtoResponse toDto() {
        return RestaurantDtoResponse.builder()
                .name(name)
                .category(category)
                .createDateTime(createDateTime)
                .build();
    }

    @Builder
    public RestaurantUpdateResponse toUpdateDto() {
        return RestaurantUpdateResponse.builder()
                .name(name)
                .category(category)
                .build();
    }

    public void updateCategory(String category) {
        this.category = category;
    }
}
