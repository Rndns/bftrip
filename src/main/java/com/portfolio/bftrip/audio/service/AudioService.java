package com.portfolio.bftrip.audio.service;

import com.portfolio.bftrip.audio.domain.Audio;
import com.portfolio.bftrip.audio.repository.AudioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AudioService {

    private final AudioRepository audioRepository;

    public List<Audio> findAudios() {
        return audioRepository.findAll();
    }

    public Optional<Audio> findById(Long audioId){
        return audioRepository.findById(audioId);
    }

    public List<Audio> findAudiosByPlace(Long placeId){
        return audioRepository.findAllByPlace(placeId);
    }

}
