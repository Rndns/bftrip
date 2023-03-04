package com.portfolio.bftrip.place.controller.pet;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.place.controller.PlaceResponse;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class PetResponse extends PlaceResponse {

    private String petAllow;

    private String petEtc;

    public PetResponse(Long id, String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList, Long userId, String petAllow, String petEtc) {
        super(id, contentType, address, img, mapX, mapY, tel, title, audioList, userId);
        this.petAllow = petAllow;
        this.petEtc = petEtc;
    }
}
