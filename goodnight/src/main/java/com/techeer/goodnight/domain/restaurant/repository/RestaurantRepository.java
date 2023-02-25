package com.techeer.goodnight.domain.restaurant.repository;

import com.techeer.goodnight.domain.restaurant.entity.Restaruant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantRepository extends  JpaRepository<Restaruant, UUID>  {
    boolean existsById(UUID id);
}