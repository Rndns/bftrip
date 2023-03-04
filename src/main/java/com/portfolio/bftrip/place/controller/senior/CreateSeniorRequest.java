package com.portfolio.bftrip.place.controller.senior;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.place.controller.CreatePlaceRequest;
import com.portfolio.bftrip.place.domain.Senior;
import com.portfolio.bftrip.user.User;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CreateSeniorRequest extends CreatePlaceRequest {

    private String parking;

    private String route;

    private String transport;

    private String wheelchair;

    private String exits;

    private String elevator;

    private String seniorEtc;

    @Builder
    public CreateSeniorRequest(String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList, Long userId, String parking, String route, String transport, String wheelchair, String exits, String elevator, String seniorEtc) {
        super(contentType, address, img, mapX, mapY, tel, title, audioList, userId);
        this.parking = parking;
        this.route = route;
        this.transport = transport;
        this.wheelchair = wheelchair;
        this.exits = exits;
        this.elevator = elevator;
        this.seniorEtc = seniorEtc;
    }

    public Senior toEntity(User user){
        return Senior.builder()
                .contentType(super.getContentType())
                .address(super.getAddress())
                .img(super.getImg())
                .mapX(super.getMapX())
                .mapY(super.getMapY())
                .tel(super.getTel())
                .title(super.getTitle())
                .audioList(super.getAudioList())
                .user(user)
                .parking(parking)
                .route(route)
                .transport(transport)
                .wheelchair(wheelchair)
                .exits(exits)
                .elevator(elevator)
                .seniorEtc(seniorEtc)
                .build();
    }
}
