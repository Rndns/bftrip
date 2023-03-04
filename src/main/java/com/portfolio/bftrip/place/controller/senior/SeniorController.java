package com.portfolio.bftrip.place.controller.senior;

import com.portfolio.bftrip.place.domain.Senior;
import com.portfolio.bftrip.place.service.SeniorService;
import com.portfolio.bftrip.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seniors")
public class SeniorController {

    private final SeniorService seniorService;

    @PostMapping("/new")
    public ResponseEntity<CreateSeniorResponse> save(@RequestBody @Valid CreateSeniorRequest request) {
        User user = null;
        Long id = seniorService.saveSenior(request.toEntity(user));

        return ResponseEntity.ok(new CreateSeniorResponse(id));
    }

    @GetMapping("")
    public ResponseEntity<SeniorResponse.Result> findSeniors(){
        List<Senior> findSeniors = seniorService.findSeniors();
        List<SeniorResponse> collect = findSeniors.stream()
                .map(s -> new SeniorResponse(s.getId(),s.getContentType(),s.getAddress(),s.getImg(),s.getMapX(),s.getMapY(),s.getTel(),s.getTitle(),s.getAudioList(),s.getUser().getId(),
                        s.getParking(),s.getRoute(),s.getTransport(),s.getWheelchair(),s.getExits(),s.getElevator(),s.getSeniorEtc()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new SeniorResponse.Result(collect));
    }
}
