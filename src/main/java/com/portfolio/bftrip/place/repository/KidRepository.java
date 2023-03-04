package com.portfolio.bftrip.place.repository;

import com.portfolio.bftrip.place.domain.Kid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KidRepository extends JpaRepository<Kid,Long> {
}
