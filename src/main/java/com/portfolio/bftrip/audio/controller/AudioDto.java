package com.portfolio.bftrip.audio.controller;

import com.portfolio.bftrip.place.domain.Place;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
public class AudioDto {

    private Long id;

    private String audioTitle;

    private String audioUrl;

    private String language;

    private String playTime;

    private String script;

    private Place place;

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T places;
    }

}
