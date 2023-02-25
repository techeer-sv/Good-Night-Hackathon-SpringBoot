package com.techeer.goodnight.domain.restaurant.repository;
import com.techeer.goodnight.domain.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long>,
        JpaRepository<Restaurant, Long> {

    @Query("select r from Restaurant r where r.categoryName = :categoryName and r.isDeleted is false")
    Page<Restaurant> findAllWithCategoryName(Pageable pageable, Optional<String> categoryName);
}