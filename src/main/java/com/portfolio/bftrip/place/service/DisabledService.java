package com.portfolio.bftrip.place.service;

import com.portfolio.bftrip.place.domain.Disabled;
import com.portfolio.bftrip.place.domain.Place;
import com.portfolio.bftrip.place.repository.DisabledRepository;
import com.portfolio.bftrip.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DisabledService {

    private final DisabledRepository disabledRepository;
    private final PlaceRepository placeRepository;

    @Transactional
    public Long saveDisabled(Disabled disabled){
        disabledRepository.save(disabled);
        return disabled.getId();
    }


    public List<Disabled> findDisabled(){
        return disabledRepository.findAll();
    }

    public Optional<Disabled> findById(Long disabledId){
        return disabledRepository.findById(disabledId);
    }

    @Transactional
    public void updateDisabled(Disabled disabled, Long id){
        Disabled findDisabled = disabledRepository.findById(disabled.getId()).orElseThrow();
        findDisabled.updatePlace(disabled.getContentType(), disabled.getAddress(), disabled.getImg(),disabled.getMapX(),disabled.getMapY(),disabled.getTel(),disabled.getTitle());
        findDisabled.updateDisabled(disabled.getParking(),disabled.getRoute(),disabled.getTransport(), disabled.getWheelchair(),disabled.getExits(), disabled.getElevator(),
                disabled.getRestroom(), disabled.getAuditorium(), disabled.getRoom(), disabled.getHandicapEtc(), disabled.getBrailleBolck(),disabled.getHelpDog(),
                disabled.getGuideHuman(),disabled.getBigPrint(), disabled.getBraillePromotion(),disabled.getGuideSystem(), disabled.getBlindEtc(), disabled.getSignGuide(),
                disabled.getVideoGuide(),disabled.getHearingRoom(),disabled.getHearingEtc());

    }
}
