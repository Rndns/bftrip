package com.portfolio.bftrip.place.controller;

import com.portfolio.bftrip.audio.domain.Audio;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class CreatePlaceRequest {

    private String contentType;

    @NotEmpty
    private String address;

    private String img;

    private String mapX;

    private String mapY;

    private String tel;

    @NotEmpty
    private String title;

    private List<Audio> audioList = new ArrayList<>();

    private Long userId;

}
