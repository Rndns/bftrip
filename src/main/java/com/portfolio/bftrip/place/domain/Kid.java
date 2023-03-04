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
import java.nio.DoubleBuffer;
import java.util.List;

@Entity
@DiscriminatorValue("Kid")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Kid extends Place {

    private String stroller;

    @Column(name = "lactation_room")
    private String lactationRoom;

    @Column(name = "baby_chair")
    private String babyChair;

    @Column(name = "family_etc")
    private String familyEtc;

    @Builder
    public Kid(Long id, Double rate, String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList, User user, String stroller, String lactationRoom, String babyChair, String familyEtc) {
        super(id, rate, contentType, address, img, mapX, mapY, tel, title, audioList, user);
        this.stroller = stroller;
        this.lactationRoom = lactationRoom;
        this.babyChair = babyChair;
        this.familyEtc = familyEtc;
    }
}
