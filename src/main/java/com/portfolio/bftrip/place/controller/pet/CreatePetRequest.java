package com.portfolio.bftrip.place.controller.pet;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.place.controller.CreatePlaceRequest;
import com.portfolio.bftrip.place.domain.Pet;
import com.portfolio.bftrip.user.User;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CreatePetRequest extends CreatePlaceRequest {

    private String petAllow;

    private String petEtc;

    @Builder
    public CreatePetRequest(String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList, Long userId, String petAllow, String petEtc) {
       super(contentType,address,img,mapX,mapY,tel,title,audioList,userId);
        this.petAllow = petAllow;
        this.petEtc = petEtc;
    }

    public Pet toEntity(User user){
        return Pet.builder()
                .contentType(super.getContentType())
                .address(super.getAddress())
                .img(super.getImg())
                .mapX(super.getMapX())
                .mapY(super.getMapY())
                .tel(super.getTel())
                .title(super.getTitle())
                .audioList(super.getAudioList())
                .user(user)
                .petAllow(petAllow)
                .petEtc(petEtc)
                .build();
    }
}
