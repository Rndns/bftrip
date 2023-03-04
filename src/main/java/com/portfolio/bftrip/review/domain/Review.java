package com.portfolio.bftrip.review.domain;

import com.portfolio.bftrip.place.domain.Place;
import com.portfolio.bftrip.user.User;
import com.sun.xml.bind.v2.TODO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    private int rate;

    private String image;

    private String content;

    private LocalDateTime createdDate;

    @Builder
    public Review(Long id, User user, Place place, int rate, String image, String content, LocalDateTime createdDate){
        this.id = id;
        this.user = user;
        this.place = place;
        this.rate = rate;
        this.image = image;
        this.content = content;
        this.createdDate = createdDate;
    }

    public void updateReview(int rate, String image, String content){
        this.rate = rate;
        this.image = image;
        this.content = content;
    }

}
