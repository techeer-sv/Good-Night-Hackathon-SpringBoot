package com.techeer.controller.restaurant;

import com.techeer.persistence.restaurant.application.RestaurantService;

import com.techeer.persistence.restaurant.dto.request.CreateRestaurantReq;
import com.techeer.persistence.restaurant.dto.response.RestaurantDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "restaurants", description = "레스토랑 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
public class RestaurantController {

  @Resource(name = "restaurantService")
  private final RestaurantService restaurantService;

  @Operation(summary = "createRestaurant", description = "레스토랑 생성")
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
}
