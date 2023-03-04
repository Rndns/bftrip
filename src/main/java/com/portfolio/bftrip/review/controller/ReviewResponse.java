package com.portfolio.bftrip.review.controller;

import com.portfolio.bftrip.place.domain.Place;
import com.portfolio.bftrip.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewResponse {
    private Long id;
    private Long userId;
    private Long placeId;
    private int rate;
    private String image;
    private String content;
    private LocalDateTime createdDate;

    @Builder
    public ReviewResponse(Long id, Long userId, Long placeId, int rate, String image, String content, LocalDateTime createdDate) {
        this.id = id;
        this.userId = userId;
        this.placeId = placeId;
        this.rate = rate;
        this.image = image;
        this.content = content;
        this.createdDate = createdDate;
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T reviews;
    }
}
