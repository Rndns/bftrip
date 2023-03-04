package com.portfolio.bftrip.place.domain;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("Pet")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Pet extends Place {

    @Column(name = "pet_allow")
    private String petAllow;
    @Column(name = "pet_etc")
    private String petEtc;

    @Builder
    public Pet(Long id, Double rate, String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList, User user, String petAllow, String petEtc) {
        super(id,rate, contentType, address, img, mapX, mapY, tel, title, audioList, user);
        this.petAllow = petAllow;
        this.petEtc = petEtc;
    }
    public void updatePet(String petAllow, String petEtc){
        this.petAllow = petAllow;
        this.petEtc = petEtc;
    }
}
