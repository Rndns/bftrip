package com.portfolio.bftrip.place.service;

import com.portfolio.bftrip.place.domain.Senior;
import com.portfolio.bftrip.place.repository.SeniorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeniorService {

    private final SeniorRepository seniorRepository;

    @Transactional
    public Long saveSenior(Senior senior){
        seniorRepository.save(senior);
        return senior.getId();
    }

    public List<Senior> findSeniors(){
        return seniorRepository.findAll();
    }

    public Optional<Senior> findById(Long seniorId){
        return seniorRepository.findById(seniorId);
    }
}
