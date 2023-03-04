package com.portfolio.bftrip.audio.controller;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.audio.service.AudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/audios")
public class AudioController {

    private final AudioService audioService;

    @GetMapping("")
    public ResponseEntity<AudioDto.Result> findAudios(){
        List<Audio> findAudios = audioService.findAudios();
        List<AudioDto> collect = findAudios.stream()
                .map(a -> new AudioDto(a.getId(),a.getAudioTitle(),a.getAudioUrl(),a.getLanguage(),a.getPlayTime(),a.getScript(),a.getPlace()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new AudioDto.Result(collect));
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<AudioDto.Result> findAudiosByPlace(@PathVariable("placeId") Long placeId){
        List<Audio> audios = audioService.findAudiosByPlace(placeId);
        List<AudioDto> collect = audios.stream()
                .map(a -> new AudioDto(a.getId(),a.getAudioTitle(),a.getAudioUrl(),a.getLanguage(),a.getPlayTime(),a.getScript(),a.getPlace()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new AudioDto.Result(collect));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AudioDto> findById(@PathVariable("id") Long id){
        Audio audio = audioService.findById(id).orElseThrow();
        return ResponseEntity.ok(new AudioDto(audio.getId(), audio.getAudioTitle(), audio.getAudioUrl(), audio.getLanguage(), audio.getPlayTime(), audio.getScript(), audio.getPlace()));
    }
}
