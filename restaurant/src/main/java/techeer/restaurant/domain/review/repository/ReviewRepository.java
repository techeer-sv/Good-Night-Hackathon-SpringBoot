package techeer.restaurant.domain.review.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import techeer.restaurant.domain.review.entity.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "select R from Review R where R.id = :id and R.isActive = true")
    Review findReviewById(@Param("id") Long id);

    @Query(value = "SELECT r\n " +
            "FROM Review r\n " +
            "WHERE (r.title = '' OR r.title Like CONCAT('%', :title, '%'))\n " +
            "AND (r.content = '' OR r.content Like CONCAT('%', :content, '%'))\n")
    List<Review> findAllWithFieldQuery(
            String title,
            String content,
            Pageable pageable
    );
}
