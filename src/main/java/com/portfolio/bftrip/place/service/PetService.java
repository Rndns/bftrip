package com.portfolio.bftrip.place.service;

import com.portfolio.bftrip.place.domain.Pet;
import com.portfolio.bftrip.place.repository.PetRepository;
import com.portfolio.bftrip.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PetService {

    private final PetRepository petRepository;

    @Transactional
    public Long savePet(Pet pet){
        User user = null;

        petRepository.save(pet);
        return pet.getId();
    }

    public List<Pet> findPets(){
        return petRepository.findAll();
    }

    public Optional<Pet> findById(Long petId){
        return petRepository.findById(petId);
    }

    public List<Pet> findPetsByTitle(String title){
        return petRepository.findByTitleContaining(title);
    }
    public List<Pet> findPetsByAddress(String address){
        return petRepository.findByAddressContaining(address);
    }

    @Transactional
    public void updatePet(Pet pet, Long id){
        System.out.println("pet: " + pet);
        Pet findPet = petRepository.findById(id).orElseThrow();
        System.out.println("find: "+ pet);
        findPet.updatePlace(pet.getContentType(),pet.getAddress(),pet.getImg(),pet.getMapX(),pet.getMapY(),pet.getTel(),pet.getTitle());
        findPet.updatePet(pet.getPetAllow(),pet.getPetEtc());

    }
}
