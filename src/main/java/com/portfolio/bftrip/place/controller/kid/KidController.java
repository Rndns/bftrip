package com.portfolio.bftrip.place.controller.kid;

import com.portfolio.bftrip.place.domain.Kid;
import com.portfolio.bftrip.place.service.KidService;
import com.portfolio.bftrip.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kids")
public class KidController {

    private final KidService kidService;

    @PostMapping("/new")
    public ResponseEntity<CreateKidResponse> save(@RequestBody @Valid CreateKidRequest request){
        User user = null;
        Long id = kidService.saveKid(request.toEntity(user));
        return ResponseEntity.ok(new CreateKidResponse(id));

    }

    @GetMapping("")
    public ResponseEntity<KidResponse.Result> findKids() {
        List<Kid> findKids = kidService.findKids();
        List<KidResponse> collect = findKids.stream()
                .map(k -> new KidResponse(k.getId(),k.getContentType(),k.getAddress(),k.getImg(),k.getMapX(),k.getMapY(),k.getTel(),k.getTitle(),k.getAudioList(),k.getUser().getId()
                        ,k.getStroller(),k.getLactationRoom(),k.getBabyChair(),k.getFamilyEtc()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new KidResponse.Result(collect));

    }


}
