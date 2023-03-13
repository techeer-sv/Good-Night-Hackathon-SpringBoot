package chanyoung.GoodNightHackathon.review.controller;

import chanyoung.GoodNightHackathon.review.domin.Review;
import chanyoung.GoodNightHackathon.review.domin.ReviewRepository;
import chanyoung.GoodNightHackathon.review.dto.ReviewRequest;
import chanyoung.GoodNightHackathon.review.dto.ReviewRequestId;
import chanyoung.GoodNightHackathon.review.dto.ReviewRequestOrder;
import chanyoung.GoodNightHackathon.review.dto.ReviewResponse;
import chanyoung.GoodNightHackathon.review.service.ReviewService;
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
    public void saveReview (@RequestBody ReviewRequest request) {
        service.save(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponse findIdReview (@PathVariable Long id) {
        return service.findId(id);
    }

    @PutMapping("/updates")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateReview(@RequestBody ReviewRequestId request) {
        service.updateReview(request.getId(), request.getTitle(), request.getContent());
    }

    @GetMapping("/removes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeReview (@PathVariable Long id) {
        service.removeReview(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse> findByTitleContent (@RequestBody ReviewRequestOrder request) {
        return service.sortReview(request.getTitle(), request.getContent(), request.getOrderType());
    }

}
