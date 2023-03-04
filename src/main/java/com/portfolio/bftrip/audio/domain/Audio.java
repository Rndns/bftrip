package com.portfolio.bftrip.audio.domain;

import com.portfolio.bftrip.place.domain.Place;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Audio {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "audio_title")
    private String audioTitle;

    @Column(name = "audio_url")
    private String audioUrl;

    private String language;

    @Column(name="play_time")
    private String playTime;

    private String script;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="place_id")
    private Place place;

    @Builder
    public Audio(Long id, String audioTitle, String audioUrl, String language, String playTime, String script, Place place) {
        this.id = id;
        this.audioTitle = audioTitle;
        this.audioUrl = audioUrl;
        this.language = language;
        this.playTime = playTime;
        this.script = script;
        this.place = place;
    }
}
