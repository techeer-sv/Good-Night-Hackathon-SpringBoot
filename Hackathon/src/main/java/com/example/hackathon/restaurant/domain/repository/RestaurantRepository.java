package com.example.hackathon.restaurant.domain.repository;

import com.example.hackathon.restaurant.domain.entity.Category;
import com.example.hackathon.restaurant.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    boolean existsByName(String name);

    // 레스토랑 수정
    @Modifying // insert, update , delete 등 db에 변화가 발생하는 작업에는 필수
    @Transactional // 이 과정 중 다른 연산이 끼어들 수 없게 하는 어노테이션
    @Query("update Restaurant r set r.category = :category where r.id = :id")
    void updateCategory(@Param("restaurant_id") Long id ,@Param("category") Category category);

    /*
    //레스토랑 카테고리에 따른 레스토랑 목록 조회
    @Query("select r from Restaurant r where r.category In :categories")
    List<Restaurant> findByCategory(@Param("category")List<Category> categories);


    // 레스토랑 삭제
    @Modifying
    @Transactional
    @Query("update Restaurant r set r.isActive = false where r.id = :id")
    void softDeleteById(Long id);

    // 레스토랑 전제 목록 조회
    @Query
    Optional<Restaurant> findByName(String restaurantName);

    */
}
