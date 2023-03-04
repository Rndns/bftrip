package com.portfolio.bftrip.bookmark.controller;

import com.portfolio.bftrip.bookmark.domain.Bookmark;
import com.portfolio.bftrip.place.domain.Place;
import com.portfolio.bftrip.user.User;
import lombok.Builder;
import lombok.Data;

@Data
public class BookmarkRequest {

    private Long id;
    private Place place;
    private User user;

    @Builder
    public BookmarkRequest(Long id, Place place, User user) {
        this.id = id;
        this.place = place;
        this.user = user;
    }

    public Bookmark toEntity(){
        return Bookmark.builder()
                .id(id)
                .place(place)
                .user(user)
                .build();
    }
}
