package com.portfolio.bftrip.place.service;

import com.portfolio.bftrip.place.domain.Kid;
import com.portfolio.bftrip.place.repository.KidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KidService {

    private final KidRepository kidRepository;

    @Transactional
    public Long saveKid(Kid kid){
        kidRepository.save(kid);
        return kid.getId();
    }

    public List<Kid> findKids(){
        return kidRepository.findAll();
    }

    public Optional<Kid> findById(Long kidId){
        return kidRepository.findById(kidId);
    }
}
