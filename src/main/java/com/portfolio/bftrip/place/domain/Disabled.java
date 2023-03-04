package com.portfolio.bftrip.place.domain;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Disabled")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@PrimaryKeyJoinColumn(name = "disabled_id")
public class Disabled extends Place {

    private String parking;

    private String route;

    private String transport;

    private String wheelchair;

    private String exits;

    private String elevator;

    private String restroom;

    private String auditorium;

    private String room;

    @Column(name = "handicap_etc")
    private String handicapEtc;

    @Column(name = "braile_block")
    private String brailleBolck;

    @Column(name = "help_dog")
    private String helpDog;

    @Column(name = "guide_human")
    private String guideHuman;

    @Column(name = "big_print")
    private String bigPrint;

    @Column(name = "braile_promotion")
    private String braillePromotion;

    @Column(name = "guide_system")
    private String guideSystem;

    @Column(name = "blind_etc")
    private String blindEtc;

    @Column(name = "sign_guide")
    private String signGuide;

    @Column(name = "video_guide")
    private String videoGuide;

    @Column(name = "hearing_room")
    private String hearingRoom;

    @Column(name = "hearing_etc")
    private String hearingEtc;

    @Builder
    public Disabled(Long id, Double rate, String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList, User user, String parking, String route, String transport, String wheelchair, String exits, String elevator, String restroom, String auditorium, String room, String handicapEtc, String brailleBolck, String helpDog, String guideHuman, String bigPrint, String braillePromotion, String guideSystem, String blindEtc, String signGuide, String videoGuide, String hearingRoom, String hearingEtc) {
        super(id, rate, contentType, address, img, mapX, mapY, tel, title, audioList, user);
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
        this.brailleBolck = brailleBolck;
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

    public void updateDisabled(String parking, String route, String transport, String wheelchair, String exits, String elevator, String restroom, String auditorium, String room, String handicapEtc, String brailleBolck, String helpDog, String guideHuman, String bigPrint, String braillePromotion, String guideSystem, String blindEtc, String signGuide, String videoGuide, String hearingRoom, String hearingEtc) {
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
        this.brailleBolck = brailleBolck;
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

