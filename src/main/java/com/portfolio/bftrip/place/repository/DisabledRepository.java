package com.portfolio.bftrip.place.repository;

import com.portfolio.bftrip.place.domain.Disabled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisabledRepository extends JpaRepository<Disabled,Long> {

    List<Disabled> findByTitleContaining(String title);

}
