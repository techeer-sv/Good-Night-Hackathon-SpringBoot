package com.example.demo.domain.restaurant.repository;

import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.global.enumpkg.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query(value = "select * from restaurant where id = :id and is_deleted = false", nativeQuery = true)
    public Restaurant findByIdNotDeleted(@Param("id") Long id);

    @Query(value = "select * from restaurant where is_deleted = false", nativeQuery = true)
    public List<Restaurant> findAllNotDeleted();

    @Query(value = "select * from restaurant where category = :category and is_deleted = false", nativeQuery = true)
    public List<Restaurant> findAllByCategoryNotDeleted(@Param("category") String category);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE restaurant SET is_deleted = true WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") Long id);

}
