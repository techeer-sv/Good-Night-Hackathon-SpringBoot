package com.techeergroup2.goodnight.domain.restaurant.domain;

import com.sun.istack.NotNull;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantDtoResponse;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantUpdateResponse;
import com.techeergroup2.goodnight.global.domain.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
@SQLDelete(sql = "UPDATE restaurant SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Restaurant extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Boolean deleted = Boolean.FALSE;

    public Restaurant(String name, String category) {
        this.name = name;
        this.category = category;
    }

//    @CreationTimestamp
//    private LocalDateTime createDateTime;
//
//    @UpdateTimestamp
//    private LocalDateTime updateDateTime;


    @Builder
    public RestaurantDtoResponse toDto() {
        return RestaurantDtoResponse.builder()
                .name(name)
                .category(category)
                .createDateTime(super.createdAt)
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
