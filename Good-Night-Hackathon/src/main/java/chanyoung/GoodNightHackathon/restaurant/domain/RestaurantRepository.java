package chanyoung.GoodNightHackathon.restaurant.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query (value = "SELECT r FROM Restaurant r WHERE r.isDeleted = FALSE" )
    List<Restaurant> findAll();

    @Query (value = "SELECT r FROM Restaurant r WHERE r.category = :category AND r.isDeleted = FALSE")
    List<Restaurant> findByCategory(@Param("category") String category);
}
