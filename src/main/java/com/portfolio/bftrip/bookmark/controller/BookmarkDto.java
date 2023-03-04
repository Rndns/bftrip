package com.portfolio.bftrip.bookmark.controller;


import com.portfolio.bftrip.place.domain.Place;
import lombok.*;

@Getter
@Setter
public class BookmarkDto {

    private Long id;
    private Long placeId;
    private Long userId;

    public BookmarkDto(Long id) {
        this.id = id;
    }

    @Builder
    public BookmarkDto(Long id, Long placeId, Long userId) {
        this.id = id;
        this.placeId = placeId;
        this.userId = userId;
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T places;
    }
}
