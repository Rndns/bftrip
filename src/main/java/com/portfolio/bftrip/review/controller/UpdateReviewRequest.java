package com.portfolio.bftrip.review.controller;

import com.portfolio.bftrip.review.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class UpdateReviewRequest {

    private int rate;

    @NotEmpty
    private String content;

    private String image;

    @Builder
    public UpdateReviewRequest(int rate, String content, String image) {
        this.rate = rate;
        this.content = content;
        this.image = image;
    }

    public Review toEntity(){
        return Review.builder()
                .rate(rate)
                .content(content)
                .image(image)
                .build();
    }
}
