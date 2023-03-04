package com.portfolio.bftrip.place.domain;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DiscriminatorFormula;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorColumn(name="DTYPE")
@Getter
@DynamicInsert
public abstract class Place {

    @Id @GeneratedValue
    @Column(name="place_id")
    private Long id;
        
    @ColumnDefault("0")
    private Double rate;

    @Column(name="content_type")
    private String contentType;

    private String address;

    private String img;

    @Column(name="map_x")
    private String mapX;

    @Column(name="map_y")
    private String mapY;

    private String tel;

    private String title;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Audio> audioList = new ArrayList<>();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Place(Long id, Double rate, String contentType, String address, String img, String mapX, String mapY, String tel, String title, List<Audio> audioList, User user) {
        this.id = id;
        this.rate = rate;
        this.contentType = contentType;
        this.address = address;
        this.img = img;
        this.mapX = mapX;
        this.mapY = mapY;
        this.tel = tel;
        this.title = title;
        this.audioList = audioList;
        this.user = user;
    }

    public void updatePlace(String contentType, String address, String img, String mapX, String mapY, String tel, String title) {
        this.contentType = contentType;
        this.address = address;
        this.img = img;
        this.mapX = mapX;
        this.mapY = mapY;
        this.tel = tel;
        this.title = title;
    }
}
