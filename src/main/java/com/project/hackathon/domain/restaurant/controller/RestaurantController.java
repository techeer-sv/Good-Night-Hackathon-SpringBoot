package com.project.hackathon.domain.restaurant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import com.project.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.project.hackathon.domain.restaurant.dto.RestaurantDetailResponse;
import com.project.hackathon.domain.restaurant.service.RestaurantService;
import com.project.hackathon.global.dto.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<RestaurantDetailResponse> createRestaurant(
            @Validated @RequestBody RestaurantCreateRequest request
            ) {
        RestaurantDetailResponse restaurantDetailResponse = restaurantService.create(request);
        return ResponseEntity.ok(restaurantDetailResponse);
    }
//
//    @GetMapping("/{boardId}")
//    public ResponseEntity<ResultResponse> getBoardDetail(@PathVariable Long boardId) {
//        BoardDetailResponse response = boardService.getBoardDetail(boardId);
//
//        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_DETAIL_GET_SUCCESS, response));
//    }
//
//    @GetMapping("/list/{page}")
//    public ResponseEntity<ResultResponse> getBoardListPage(
//            @PathVariable int page,
//            @RequestParam(required = false, defaultValue = "10") int size,
//            @RequestParam(defaultValue = "false", required = false) boolean isTimeReversed) {
//        BoardListResponse response = boardService.getBoardListPage(page, size, isTimeReversed);
//
//        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_LIST_PAGE_GET_SUCCESS, response));
//    }
//
//    @GetMapping("/search/{page}")
//    public ResponseEntity<ResultResponse> searchBoardWithTitleOrContent(
//            @PathVariable int page,
//            @RequestParam(required = false) int size,
//            @RequestParam(defaultValue = "false", required = false) boolean isTimeReversed,
//            @RequestParam String search) {
//        BoardListResponse response =
//                boardService.searchBoardWithTitleOrContent(page, size, isTimeReversed, search);
//
//        return ResponseEntity.ok(
//                ResultResponse.of(ResultCode.BOARD_LIST_PAGE_SEARCH_SUCCESS, response));
//    }
//
//    @PutMapping
//    public ResponseEntity<ResultResponse> updateBoardDetail(@Valid BoardUpdateRequest request) {
//        BoardDetailResponse response = boardService.updateBoard(request);
//
//        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_DETAIL_UPDATE_SUCCESS, response));
//    }
//
//    @DeleteMapping("/{boardId}")
//    public ResponseEntity<ResultResponse> deleteBoard(
//            @PathVariable Long boardId, @RequestParam Long userId) {
//        boardService.deleteBoard(boardId, userId);
//
//        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_DELETE_SUCCESS, new Object()));
//    }
}