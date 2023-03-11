package chanyoung.GoodNightHackathon.restaurant.service;

import chanyoung.GoodNightHackathon.restaurant.domain.Restaurant;
import chanyoung.GoodNightHackathon.restaurant.domain.RestaurantRepository;
import chanyoung.GoodNightHackathon.restaurant.dto.requeset.RestaurantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //생성자 주입
public class RestaurantService {
    private final RestaurantRepository repository;

    public void save(RestaurantRequest request) {
        Restaurant restaurant = Restaurant.builder()
                                    .name(request.getName())
                                    .category(request.getCategory())
                                    .build();
        repository.save(restaurant);
    }

    public List<Restaurant> findTotal() {
        return repository.findAll();
    }

    public void update(Long id, String category) {
        Optional<Restaurant> restaurant = repository.findById(id);
        restaurant.get().update(category);
        repository.save(restaurant.get());
    }

    public Optional<Restaurant> findId (Long id) {
        Optional<Restaurant> restaurant = repository.findById(id);
        return restaurant;
    }

    public List<Restaurant> findCategory (String category) {
        List<Restaurant> restaurant = repository.findByCategory(category);
        return restaurant;
    }

    public void removeRestaurant (Long id) {
        Optional<Restaurant> restaurant = repository.findById(id);
        restaurant.get().delete(); //soft delete 위한 db isDelete 변경 작업
        repository.save(restaurant.get());
    }

}
