package techeer.restaurant.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import techeer.restaurant.domain.review.entity.Review;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "select R from Review R where R.id = :id and R.isActive = true")
    Review findReviewById(@Param("id") Long id);

}
