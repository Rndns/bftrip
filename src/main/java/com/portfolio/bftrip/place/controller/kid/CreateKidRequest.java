package com.portfolio.bftrip.place.controller.kid;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.place.controller.CreatePlaceRequest;
import com.portfolio.bftrip.place.domain.Kid;
import com.portfolio.bftrip.user.User;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CreateKidRequest extends CreatePlaceRequest {

    private String stroller;

    private String lactationRoom;

    private String babyChair;

    private String familyEtc;

    @Builder
    public CreateKidRequest(String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList, Long userId, String stroller, String lactationRoom, String babyChair, String familyEtc) {
        super(contentType,address,img,mapX,mapY,tel,title,audioList,userId);
        this.stroller = stroller;
        this.lactationRoom = lactationRoom;
        this.babyChair = babyChair;
        this.familyEtc = familyEtc;
    }

    public Kid toEntity(User user){
        return Kid.builder()
                .contentType(super.getContentType())
                .address(super.getAddress())
                .img(super.getImg())
                .mapX(super.getMapX())
                .mapY(super.getMapY())
                .tel(super.getTel())
                .title(super.getTitle())
                .audioList(super.getAudioList())
                .user(user)
                .stroller(stroller)
                .lactationRoom(lactationRoom)
                .babyChair(babyChair)
                .familyEtc(familyEtc)
                .build();
    }
}
