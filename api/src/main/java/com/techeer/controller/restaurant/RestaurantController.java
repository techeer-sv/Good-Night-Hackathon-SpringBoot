package com.techeer.controller.restaurant;

import com.techeer.persistence.restaurant.application.RestaurantService;

import com.techeer.persistence.restaurant.dto.request.CreateRestaurantReq;
import com.techeer.persistence.restaurant.dto.request.PatchRestaurantReq;
import com.techeer.persistence.restaurant.dto.response.RestaurantDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@Tag(name = "restaurants", description = "레스토랑 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
public class RestaurantController {

  @Resource(name = "restaurantService")
  private final RestaurantService restaurantService;

  @Operation(summary = "getRestaurant", description = "레스토랑 목록 조회")
  @GetMapping()
  public ResponseEntity<Page<RestaurantDTO>> get(
          @PageableDefault(sort ="id", direction = Sort.Direction.DESC)
          Pageable pageable,
          @RequestParam(value = "categoryName", required = false) Optional<String> categoryName
  ) {
    return new ResponseEntity<>(restaurantService.getRestaurants(pageable, categoryName), HttpStatus.OK);
  }


  @Operation(summary = "createRestaurant", description = "레스토랑 등록")
  @ApiResponses({
          @ApiResponse(responseCode = "201", description = "CREATED",
                  content = @Content(schema = @Schema(implementation = RestaurantDTO.class)))
  })
  @PostMapping()
  public ResponseEntity<RestaurantDTO> create(
          @RequestBody final CreateRestaurantReq createRestaurantReq
  ) {
    return new ResponseEntity<>(restaurantService.create(createRestaurantReq), HttpStatus.CREATED);
  }

  @Operation(summary = "getRestaurantById", description = "레스토랑 조회")
  @ApiResponses({
          @ApiResponse(responseCode = "200", description = "OK",
                  content = @Content(schema = @Schema(implementation = RestaurantDTO.class))),
          @ApiResponse(responseCode = "-200", description = "RESTAURANT_ID_NOT_FOUND"),
  })
  @GetMapping("/{id}")
  public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable final long id) {
    return new ResponseEntity<>(restaurantService.findById(id), HttpStatus.OK);
  }

  @Operation(summary = "patchRestaurantById", description = "레스토랑 수정")
  @PatchMapping("/{id}")
  public ResponseEntity<RestaurantDTO> patchRestaurantById(
          @PathVariable final long id,
          @RequestBody final PatchRestaurantReq patchRestaurantReq) {
    return new ResponseEntity<>(restaurantService.patchById(id, patchRestaurantReq), HttpStatus.OK);
  }
}
