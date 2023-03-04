package com.portfolio.bftrip.place.controller;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public abstract class PlaceResponse {

    private Long id;

    private String contentType;

    private String address;

    private String img;

    private String mapX;

    private String mapY;

    private String tel;

    private String title;

    private List<Audio> audioList = new ArrayList<>();

    private Long userId;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Result<T>{
        private T places;
    }
}
