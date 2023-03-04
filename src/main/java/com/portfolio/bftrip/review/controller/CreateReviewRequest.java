package com.portfolio.bftrip.review.controller;

import com.portfolio.bftrip.review.domain.Review;
import com.portfolio.bftrip.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
public class CreateReviewRequest{

    @NotEmpty
    private Long userId;

    @NotNull
    private Long placeId;

    private int rate;

    @NotEmpty
    private String content;

    private String image;

    private LocalDateTime createdDate;

    @Builder
    public CreateReviewRequest(Long placeId, int rate, String content, String image, LocalDateTime createdDate) {
        this.placeId = placeId;
        this.rate = rate;
        this.content = content;
        this.image = image;
        this.createdDate = createdDate;
    }
    public Review toEntity(){
        return Review.builder()
                .id(placeId)
                .rate(rate)
                .content(content)
                .image(image)
                .createdDate(LocalDateTime.now())
                .build();
    }
}
