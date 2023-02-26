package com.gilyeon.hackathon.domain.restaurant;

import com.gilyeon.hackathon.domain.restaurant.entity.Restaurant;
import com.gilyeon.hackathon.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("SELECT r FROM Restaurant r WHERE r.id = :id AND r.isDeleted = false")
    Optional<Restaurant> findById(@Param("id") Long id);

    @Query("SELECT r FROM Restaurant r WHERE r.isDeleted is false")
    Page<Restaurant> findRestaurantWithPagination(Pageable pageable);

}

