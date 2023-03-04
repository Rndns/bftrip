package com.portfolio.bftrip.place.controller.disabled;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.place.controller.PlaceResponse;
import com.portfolio.bftrip.place.domain.Disabled;
import lombok.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class DisabledResponse extends PlaceResponse {

    private String parking;

    private String route;

    private String transport;

    private String wheelchair;

    private String exits;

    private String elevator;

    private String restroom;

    private String auditorium;

    private String room;

    private String handicapEtc;

    private String brailleBlock;

    private String helpDog;

    private String guideHuman;

    private String bigPrint;

    private String braillePromotion;

    private String guideSystem;

    private String blindEtc;

    private String signGuide;

    private String videoGuide;

    private String hearingRoom;

    private String hearingEtc;

    @Builder
    public DisabledResponse(Long id, String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList,Long userId, String parking, String route, String transport, String wheelchair, String exits, String elevator, String restroom, String auditorium, String room, String handicapEtc, String brailleBlock, String helpDog, String guideHuman, String bigPrint, String braillePromotion, String guideSystem, String blindEtc, String signGuide, String videoGuide, String hearingRoom, String hearingEtc) {
        super(id,contentType,address,img,mapX,mapY,tel,title,audioList,userId);
        this.parking = parking;
        this.route = route;
        this.transport = transport;
        this.wheelchair = wheelchair;
        this.exits = exits;
        this.elevator = elevator;
        this.restroom = restroom;
        this.auditorium = auditorium;
        this.room = room;
        this.handicapEtc = handicapEtc;
        this.brailleBlock = brailleBlock;
        this.helpDog = helpDog;
        this.guideHuman = guideHuman;
        this.bigPrint = bigPrint;
        this.braillePromotion = braillePromotion;
        this.guideSystem = guideSystem;
        this.blindEtc = blindEtc;
        this.signGuide = signGuide;
        this.videoGuide = videoGuide;
        this.hearingRoom = hearingRoom;
        this.hearingEtc = hearingEtc;
    }


}
