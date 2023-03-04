package com.portfolio.bftrip.place.controller.kid;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.place.controller.PlaceResponse;
import com.portfolio.bftrip.review.controller.ReviewResponse;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class KidResponse extends PlaceResponse {

    private String stroller;

    private String lactationRoom;

    private String babyChair;

    private String familyEtc;

    public KidResponse(Long id, String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList, Long userId, String stroller, String lactationRoom, String babyChair, String familyEtc) {
        super(id, contentType, address, img, mapX, mapY, tel, title, audioList, userId);
        this.stroller = stroller;
        this.lactationRoom = lactationRoom;
        this.babyChair = babyChair;
        this.familyEtc = familyEtc;
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T places;
    }


}
