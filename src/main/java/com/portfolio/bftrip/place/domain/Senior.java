package com.portfolio.bftrip.place.domain;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Entity
@DiscriminatorValue("Senior")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Senior extends Place {

    private String parking;

    private String route;

    private String transport;

    private String wheelchair;

    private String exits;

    private String elevator;

    private String seniorEtc;

    @Builder
    public Senior(Long id, Double rate, String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList,User user, String parking, String route, String transport, String wheelchair, String exits, String elevator, String seniorEtc) {
        super(id, rate, contentType, address, img, mapX, mapY, tel, title, audioList, user);
        this.parking = parking;
        this.route = route;
        this.transport = transport;
        this.wheelchair = wheelchair;
        this.exits = exits;
        this.elevator = elevator;
        this.seniorEtc = seniorEtc;
    }
}
