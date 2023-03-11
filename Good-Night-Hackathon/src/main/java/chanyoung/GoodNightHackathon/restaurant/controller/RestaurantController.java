package chanyoung.GoodNightHackathon.restaurant.controller;

import chanyoung.GoodNightHackathon.restaurant.domain.Restaurant;
import chanyoung.GoodNightHackathon.restaurant.dto.requeset.RestaurantRequest;
import chanyoung.GoodNightHackathon.restaurant.dto.requeset.RestaurantRequestId;
import chanyoung.GoodNightHackathon.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/restaurants")
@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService service;

    @PostMapping("/save")
    public void saveRestaurant (@RequestBody RestaurantRequest request) {
        service.save(request);
    }

    @GetMapping
    public List<Restaurant> findTotalRestaurant () {
        return service.findTotal();
    }

    @PutMapping
    public void updateRestaurant(@RequestBody RestaurantRequestId request) {
        service.update(request.getId(), request.getCategory());
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> findIdRestaurant (@PathVariable Long id) {
        return service.findId(id);
    }

    @GetMapping("/categorys")
    public List<Restaurant> findCategoryRestaurant (@RequestParam(value = "category") String category) {
        System.out.println(category);
        return service.findCategory(category);
    }

    @GetMapping("/remove/{id}")
    public void removeRestaurant (@PathVariable Long id) {
        service.removeRestaurant(id);
    }
}
