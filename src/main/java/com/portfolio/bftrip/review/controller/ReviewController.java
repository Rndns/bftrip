package com.portfolio.bftrip.review.controller;

import com.portfolio.bftrip.review.domain.Review;
import com.portfolio.bftrip.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/new")
    public ResponseEntity<CreateReviewResponse> saveReview(@RequestBody @Valid CreateReviewRequest request){
        Long saveReview = reviewService.saveReview(request.toEntity(),request.getPlaceId(), request.getUserId());
        return ResponseEntity.ok(new CreateReviewResponse(saveReview));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ReviewResponse.Result> findReviewByUser(@PathVariable("userId") Long userId){
        List<Review> findReviews = reviewService.findReviewsByUser(userId);
        List<ReviewResponse> collect = findReviews.stream()
                .map(r -> new ReviewResponse(r.getId(),r.getUser().getId(),r.getPlace().getId(), r.getRate(), r.getImage(), r.getContent(), r.getCreatedDate()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ReviewResponse.Result(collect));
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<ReviewResponse.Result> findReviewByPlace(@PathVariable("placeId") Long placeId){
        List<Review> findReviews = reviewService.findReviewsByPlace(placeId);
        List<ReviewResponse> collect = findReviews.stream()
                .map(r -> new ReviewResponse(r.getId(),r.getUser().getId(),r.getPlace().getId(), r.getRate(), r.getImage(), r.getContent(), r.getCreatedDate()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ReviewResponse.Result(collect));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReviewResponse> updateReview(@PathVariable("id") Long id, @RequestBody @Valid UpdateReviewRequest request){
        reviewService.updateReview(id, request.toEntity());
        Review findReview = reviewService.findById(id);
        return ResponseEntity.ok(ReviewResponse.builder().id(findReview.getId())
                .userId(findReview.getUser().getId())
                .placeId(findReview.getPlace().getId())
                .rate(findReview.getRate())
                .image(findReview.getImage())
                .content(findReview.getContent())
                .createdDate(findReview.getCreatedDate())
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteReview(@PathVariable("id") Long id){
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

}
