package com.portfolio.bftrip.place.controller.disabled;

import com.portfolio.bftrip.place.domain.Disabled;
import com.portfolio.bftrip.place.service.DisabledService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/disabled")
public class DisabledController {

    private final DisabledService disabledService;

    @PostMapping("/new")
    public ResponseEntity<CreateDisabledResponse> save(@RequestBody @Valid DisabledRequest request){
        Long id = disabledService.saveDisabled(request.toEntity());
        return ResponseEntity.ok(new CreateDisabledResponse(id));

    }
    @GetMapping("")
    public ResponseEntity<DisabledResponse.Result> findDisabled(){
        List<Disabled> findDisabled = disabledService.findDisabled();
        List<DisabledResponse> collect = findDisabled.stream()
                .map(d -> new DisabledResponse(d.getId(),d.getContentType(),d.getAddress(),d.getImg(),d.getMapX(),d.getMapY(),d.getTel(),d.getTitle(),d.getAudioList(),d.getUser().getId()
                        ,d.getParking(),d.getRoute(),d.getTransport(),d.getWheelchair(),d.getExits(),d.getElevator(),d.getRestroom(),d.getAuditorium(),d.getRoom(),d.getHandicapEtc()
                        ,d.getBrailleBolck(),d.getHelpDog(),d.getGuideHuman(),d.getBigPrint(),d.getBraillePromotion(),d.getGuideSystem(),d.getBlindEtc()
                        ,d.getSignGuide(),d.getVideoGuide(),d.getHearingRoom(),d.getHearingEtc()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new DisabledResponse.Result(collect));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DisabledResponse> updateDisabled(@PathVariable("id") Long id, @RequestBody @Valid DisabledRequest request){
        disabledService.updateDisabled(request.toEntity(),id);
        return ResponseEntity.ok().build();
    }

}
