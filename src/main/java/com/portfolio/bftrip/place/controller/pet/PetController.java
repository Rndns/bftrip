package com.portfolio.bftrip.place.controller.pet;

import com.portfolio.bftrip.place.controller.PlaceResponse;
import com.portfolio.bftrip.place.controller.disabled.CreateDisabledResponse;
import com.portfolio.bftrip.place.domain.Pet;
import com.portfolio.bftrip.place.service.PetService;
import com.portfolio.bftrip.user.User;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @PostMapping("/new")
    public ResponseEntity<CreatePetResponse> save(@RequestBody @Valid CreatePetRequest request){
        User user = null;
        Long id = petService.savePet(request.toEntity(user));
        return ResponseEntity.ok(new CreatePetResponse(id));
    }

    @GetMapping("")
    public ResponseEntity<PetResponse.Result> findPets() {
        List<Pet> findPets = petService.findPets();
        System.out.println("Pet :" + findPets);
        List<PetResponse> collect = findPets.stream()
                .map(p -> new PetResponse(p.getId(),p.getContentType(),p.getAddress(),p.getImg(),p.getMapX(),p.getMapY(),p.getTel(),p.getTitle(),p.getAudioList(),1L
                    ,p.getPetAllow(),p.getPetEtc()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new PetResponse.Result(collect));

    }
//    @GetMapping("/search")
//    public ResponseEntity<PlaceResponse.Result> findPetsByKeyword(@RequestParam(value = "keyword") String keyword){
//        List<Pet> findPets = petService.findPetsByTitle(keyword);
//        findPets.addAll(petService.findPetsByAddress(keyword));
//        List<PetResponse> collect = findPets.stream()
//                .map(p -> new PetResponse(p.getId(),p.getContentType(),p.getAddress(),p.getImg(),p.getMapX(),p.getMapY(),p.getTel(),p.getTitle(),p.getAudioList(),1L
//                        ,p.getPetAllow(),p.getPetEtc()))
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(new PlaceResponse.Result(collect));
//    }

    @GetMapping("/search")
    public ResponseEntity<PlaceResponse.Result> findPetsByTitle(@RequestParam(value = "title") String title){
        List<Pet> findPets = petService.findPetsByTitle(title);
        List<PetResponse> collect = findPets.stream()
                .map(p -> new PetResponse(p.getId(),p.getContentType(),p.getAddress(),p.getImg(),p.getMapX(),p.getMapY(),p.getTel(),p.getTitle(),p.getAudioList(),1L
                        ,p.getPetAllow(),p.getPetEtc()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new PlaceResponse.Result(collect));
    }
//    @GetMapping("/search")
//    public ResponseEntity<PlaceResponse.Result> findPetsByAddress(@RequestParam(value = "address") String address){
//        List<Pet> findPets = petService.findPetsByAddress(address);
//        List<PetResponse> collect = findPets.stream()
//                .map(p -> new PetResponse(p.getId(),p.getContentType(),p.getAddress(),p.getImg(),p.getMapX(),p.getMapY(),p.getTel(),p.getTitle(),p.getAudioList(),1L
//                        ,p.getPetAllow(),p.getPetEtc()))
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(new PlaceResponse.Result(collect));
//    }

    @PatchMapping("/{id}")
    public ResponseEntity updatePet(@RequestBody UpdatePetRequest request, @PathVariable("id") Long id){
        System.out.println("Request: "+request.toEntity());
//        if(!petService.findById(id).isPresent()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new NotFoundException("일치하는 장소가 없습니다."));
//        }
        petService.updatePet(request.toEntity(),id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletePet(@PathVariable("id") Long id){
//        if(!petService.findById(id).isPresent()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new NotFoundException("일치하는 장소가 없습니다."));
//        }
        return ResponseEntity.noContent().build();
    }
}
