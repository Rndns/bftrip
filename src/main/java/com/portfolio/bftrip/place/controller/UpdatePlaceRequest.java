package com.portfolio.bftrip.place.controller;

import com.portfolio.bftrip.audio.domain.Audio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class UpdatePlaceRequest {

    private String contentType;

    @NotEmpty
    private String address;

    private String img;

    private String mapX;

    private String mapY;

    private String tel;

    @NotEmpty
    private String title;

}
