package com.portfolio.bftrip.place.repository;

import com.portfolio.bftrip.place.domain.Senior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeniorRepository extends JpaRepository<Senior, Long> {

}
