package chanyoung.GoodNightHackathon.review.controller;

import chanyoung.GoodNightHackathon.review.domin.Review;
import chanyoung.GoodNightHackathon.review.domin.ReviewRepository;
import chanyoung.GoodNightHackathon.review.dto.ReviewRequest;
import chanyoung.GoodNightHackathon.review.dto.ReviewRequestId;
import chanyoung.GoodNightHackathon.review.dto.ReviewRequestOrder;
import chanyoung.GoodNightHackathon.review.dto.ReviewResponse;
import chanyoung.GoodNightHackathon.review.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/reviews")
@RestController
@RequiredArgsConstructor
@Controller
public class ReviewController {

    private final ReviewService service;
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "리뷰 추가")
    public void saveReview (@RequestBody ReviewRequest request) {
        service.save(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "라뷰 조회 by id")
    public ReviewResponse findIdReview (@PathVariable Long id) {
        return service.findId(id);
    }

    @PutMapping("/updates")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "리뷰 업데이트")
    public void updateReview(@RequestBody ReviewRequestId request) {
        service.updateReview(request.getId(), request.getTitle(), request.getContent());
    }

    @DeleteMapping("/removes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "리뷰 지우기 by id")
    public void removeReview (@PathVariable Long id) {
        service.removeReview(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "리뷰 조회 by 제목 내용")
    public List<ReviewResponse> findByTitleContent (@RequestBody ReviewRequestOrder request) {
        return service.sortReview(request.getTitle(), request.getContent(), request.getOrderType());
    }

}
