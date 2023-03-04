package com.portfolio.bftrip.place.repository;

import com.portfolio.bftrip.place.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByTitleContaining(String title);
    List<Pet> findByAddressContaining(String address);
}
