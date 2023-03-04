package com.portfolio.bftrip.review.repository;

import com.portfolio.bftrip.place.domain.Place;
import com.portfolio.bftrip.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query("select distinct r from Review r join fetch r.user u where u.id = :userId order by r.createdDate desc")
    List<Review> findAllByUserOrderByCreatedDateDesc(Long userid);
    @Query("select distinct r from Review r join fetch r.place p where p.id = :postId order by r.createdDate desc")
    List<Review> findAllByPlaceOrderByCreatedDateDesc(Long placeId);

}
