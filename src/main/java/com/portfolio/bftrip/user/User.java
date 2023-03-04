package com.portfolio.bftrip.user;

import com.portfolio.bftrip.bookmark.domain.Bookmark;
import com.portfolio.bftrip.place.domain.Place;
import com.portfolio.bftrip.review.domain.Review;
import com.portfolio.bftrip.user.cofig.Role;
import com.portfolio.bftrip.user.custom.TimeEntity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class User extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, length = 400)
    private String password;

    @Column(nullable = false, length = 400)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Bookmark> bookmarks;

    @OneToMany(mappedBy = "user")
    private List<Place> places;

    public void modify(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
