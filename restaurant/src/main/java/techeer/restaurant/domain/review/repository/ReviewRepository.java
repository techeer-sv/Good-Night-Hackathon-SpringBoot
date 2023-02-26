package techeer.restaurant.domain.review.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.css.CSS2Properties;
import techeer.restaurant.domain.review.entity.Review;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "select R from Review R where R.id = :id and R.isActive = true")
    Review findReviewById(@Param("id") Long id);

    Page<Review> findByTitleContainingIgnoreCaseAndContentContainingIgnoreCaseOrderByCreatedAtDesc(String title, String content, PageRequest pageRequest);

    Page<Review> findByTitleContainingIgnoreCaseAndContentContainingIgnoreCaseOrderByCreatedAtAsc(String title, String content, PageRequest pageRequest);

    Page<Review> findByTitleContainingIgnoreCaseOrderByCreatedAtDesc(String title, PageRequest pageRequest);

    Page<Review> findByTitleContainingIgnoreCaseOrderByCreatedAtAsc(String title, PageRequest pageRequest);

    Page<Review> findByContentContainingIgnoreCaseOrderByCreatedAtDesc(String content, PageRequest pageRequest);

    Page<Review> findAllByOrderByCreatedAtDesc(PageRequest pageRequest);

    Page<Review> findByContentContainingIgnoreCaseOrderByCreatedAtAsc(String content, PageRequest pageRequest);

    Page<Review> findAllByOrderByCreatedAtAsc(PageRequest pageRequest);
}
