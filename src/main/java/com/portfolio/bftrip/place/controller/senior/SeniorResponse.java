package com.portfolio.bftrip.place.controller.senior;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.place.controller.PlaceResponse;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SeniorResponse extends PlaceResponse {

    private String parking;

    private String route;

    private String transport;

    private String wheelchair;

    private String exits;

    private String elevator;

    private String seniorEtc;

    public SeniorResponse(Long id, String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList, Long userId, String parking, String route, String transport, String wheelchair, String exits, String elevator, String seniorEtc) {
        super(id, contentType, address, img, mapX, mapY, tel, title, audioList, userId);
        this.parking = parking;
        this.route = route;
        this.transport = transport;
        this.wheelchair = wheelchair;
        this.exits = exits;
        this.elevator = elevator;
        this.seniorEtc = seniorEtc;
    }


    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T places;
    }


}
