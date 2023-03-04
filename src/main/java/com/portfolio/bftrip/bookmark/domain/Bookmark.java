package com.portfolio.bftrip.bookmark.domain;

import com.portfolio.bftrip.place.domain.Place;
import com.portfolio.bftrip.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// TODO USER 추가
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;


    @Builder
    public Bookmark(Long id, Place place, User user){
        this.id = id;
        this.user = user;
        this.place = place;
    }
}
