package com.portfolio.bftrip.audio.repository;

import com.portfolio.bftrip.audio.domain.Audio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudioRepository extends JpaRepository<Audio, Long> {
        List<Audio> findAllByPlace(Long placeId);
}
