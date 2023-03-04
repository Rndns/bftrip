package com.portfolio.bftrip.review.service;

import com.portfolio.bftrip.exception.NotValidImageException;
import com.portfolio.bftrip.place.domain.Place;
import com.portfolio.bftrip.place.repository.PlaceRepository;
import com.portfolio.bftrip.review.domain.Review;
import com.portfolio.bftrip.review.repository.ReviewRepository;
import com.portfolio.bftrip.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.PersistenceUnit;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final PlaceRepository placeRepository;

    // userRepo

    @Transactional
    public Long saveReview(Review review, Long placeId, Long userId){
        // TODO 리뷰 생성 USER 추가 -> 리뷰도 타입별로 보이도록? 아니면 모두 같이 보이도록?
        Place place = placeRepository.findById(placeId)
                        .orElseThrow(NullPointerException::new);
        Review savedReview = reviewRepository.save(review);

        return savedReview.getId();
    }
    public String saveImage(Long id, MultipartFile image) throws IOException {
        String path = "D:/SideProject/bftrip_img/reviews";
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        if(!image.isEmpty()){
            String contentType = image.getContentType();
            String originalFileExtension;
            if(ObjectUtils.isEmpty(contentType)){
                throw new NotValidImageException();
            } else {
                if(contentType.contains("image/jpeg")){
                    originalFileExtension = ".jpg";
                } else if(contentType.contains("image/png")){
                    originalFileExtension = ".png";
                } else {
                    throw new NotValidImageException();
                }
            }
            path += "/" + "review_"+id+originalFileExtension;
            file = new File(path);
            image.transferTo(file);
        }
        return path;
    }
    public List<Review> findReviewsByPlace(Long placeId){
        return reviewRepository.findAllByPlaceOrderByCreatedDateDesc(placeId);
    }

    public List<Review> findReviewsByUser(Long userId){
        return reviewRepository.findAllByUserOrderByCreatedDateDesc(userId);
    }

    public Review findById(Long id){
        return reviewRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void updateReview(Long id,Review review){
        Review findReview = reviewRepository.findById(id).orElseThrow();
        findReview.updateReview(review.getRate(),review.getImage(),review.getContent());
    }
    @Transactional
    public void deleteReview(Long id){
        Review findReview = reviewRepository.findById(id).orElseThrow();
        reviewRepository.delete(findReview);

    }

}
