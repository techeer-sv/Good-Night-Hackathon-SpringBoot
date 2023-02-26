package com.example.demo.domain.review.repository;

import com.example.demo.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select * from review order by id desc limit :page, :size", nativeQuery = true)
    public List<Review> findAllOrderByCreatedAtDesc(@Param("page") int page, @Param("size") int size);

    @Query(value = "select * from review where title like %:searchKeyword% or content like %:searchKeyword% order by id desc limit :page, :size", nativeQuery = true)
    public List<Review> findAllContainingTitleAndContentOrderByCreatedAtDesc(@Param("searchKeyword") String searchKeyword
            , @Param("page") int page, @Param("size") int size);

    @Query(value = "select * from review where title like %:searchKeyword% order by id desc limit :page, :size", nativeQuery = true)
    public List<Review> findAllContainingTitleOrderByCreatedAtDesc(@Param("searchKeyword") String searchKeyword
            , @Param("page") int page, @Param("size") int size);

    @Query(value = "select * from review where content like %:searchKeyword% order by id desc limit :page, :size", nativeQuery = true)
    public List<Review> findAllContainingContentOrderByCreatedAtDesc(@Param("searchKeyword") String searchKeyword
            , @Param("page") int page, @Param("size") int size);
}
