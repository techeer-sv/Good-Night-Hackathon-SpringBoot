package chanyoung.GoodNightHackathon.restaurant.controller;

import chanyoung.GoodNightHackathon.restaurant.domain.Restaurant;
import chanyoung.GoodNightHackathon.restaurant.dto.requeset.RestaurantRequest;
import chanyoung.GoodNightHackathon.restaurant.dto.requeset.RestaurantRequestId;
import chanyoung.GoodNightHackathon.restaurant.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/restaurants")
@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService service;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "레스토랑 추가")
//    @Parameters({
//            @Parameter(name = "name", example = "우동집"),
//            @Parameter(name = "category", example = "일식")
//    })
    public void saveRestaurant (@RequestBody RestaurantRequest request) {
        service.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "레스토랑 전체 조회 ")
    public List<Restaurant> findTotalRestaurant () {
        return service.findTotal();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "레스토랑 업데이트")
    public void updateRestaurant(@RequestBody RestaurantRequestId request) {
        service.update(request.getId(), request.getCategory());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "레스토랑 조회 by id")
    public Restaurant findIdRestaurant (@PathVariable Long id) {
        return service.findId(id);
    }

    @GetMapping("/categorys")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "레스토랑 조회 by category")
    public List<Restaurant> findCategoryRestaurant (@RequestParam(value = "category") String category) {
        System.out.println(category);
        return service.findCategory(category);
    }

    @DeleteMapping("/remove/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "레스토랑 지우기 by id")
    public void removeRestaurant (@PathVariable Long id) {
        service.removeRestaurant(id);
    }
}
