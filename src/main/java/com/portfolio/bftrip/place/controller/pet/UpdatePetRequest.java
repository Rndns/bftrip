package com.portfolio.bftrip.place.controller.pet;

import com.portfolio.bftrip.place.controller.UpdatePlaceRequest;
import com.portfolio.bftrip.place.domain.Pet;
import com.portfolio.bftrip.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class UpdatePetRequest extends UpdatePlaceRequest {

    private String petAllow;

    private String petEtc;

    @Builder

    public UpdatePetRequest(String contentType, @NotEmpty String address, String img, String mapX, String mapY, String tel, @NotEmpty String title, String petAllow, String petEtc) {
        super(contentType, address, img, mapX, mapY, tel, title);
        this.petAllow = petAllow;
        this.petEtc = petEtc;
    }

    public Pet toEntity(){
        return Pet.builder()
                .contentType(super.getContentType())
                .address(super.getAddress())
                .img(super.getImg())
                .mapX(super.getMapX())
                .mapY(super.getMapY())
                .tel(super.getTel())
                .title(super.getTitle())
                .petAllow(petAllow)
                .petEtc(petEtc)
                .build();
    }
}
