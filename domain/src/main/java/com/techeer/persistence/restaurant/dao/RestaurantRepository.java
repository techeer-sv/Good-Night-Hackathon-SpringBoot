package com.techeer.persistence.restaurant.dao;

import com.techeer.persistence.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long>,
    JpaRepository<Restaurant, Long> {
}
