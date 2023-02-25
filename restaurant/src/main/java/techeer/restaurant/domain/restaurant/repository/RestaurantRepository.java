package techeer.restaurant.domain.restaurant.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import techeer.restaurant.domain.restaurant.dto.RestaurantInfo;
import techeer.restaurant.domain.restaurant.entity.Restaurant;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    @Query("select R from Restaurant R where R.id= :id and R.isActive is true")
    Restaurant findRestaurantById(@Param("id") Long id);

    @Query("select R from Restaurant R where R.isActive is true")
    List<Restaurant> findAllRestaurant();

}
