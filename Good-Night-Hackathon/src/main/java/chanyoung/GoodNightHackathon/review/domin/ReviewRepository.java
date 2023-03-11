package chanyoung.GoodNightHackathon.review.domin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.title LIKE %:title% AND r.content LIKE %:content%")
    Page<Review> findByTitleContent(Pageable pageable, @Param("title") String title, @Param("content") String content);
}
