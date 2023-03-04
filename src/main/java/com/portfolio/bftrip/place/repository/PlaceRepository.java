package com.portfolio.bftrip.place.repository;

import com.portfolio.bftrip.place.domain.Pet;
import com.portfolio.bftrip.place.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

//@NoRepositoryBean
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {


}
