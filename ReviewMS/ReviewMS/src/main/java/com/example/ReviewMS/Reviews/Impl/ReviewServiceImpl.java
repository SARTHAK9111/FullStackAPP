package com.example.ReviewMS.Reviews.Impl;

import com.example.ReviewMS.Reviews.Review;
import com.example.ReviewMS.Reviews.ReviewRepository;
import com.example.ReviewMS.Reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;

    }

    @Override
    public List<Review> getAllReviews(Long CompnayID) {

        List<Review> reviews = reviewRepository.findByCompanyId(CompnayID);
        return reviews;
    }

    @Override
    public boolean addReview(Long compantId, Review review) {


        if(compantId != null && review != null) {
            review.setCompanyId(compantId);
            reviewRepository.save(review);
            return true ;
        }else{
            return false;
        }
    }

    @Override
    public Review getReview( Long reviewId){
        return reviewRepository.findById(reviewId).orElse(null);


    }

    @Override
    public  boolean updateReview( Long reviewId, Review updateReview ) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
       if(review != null){
           review.setTitle(updateReview.getTitle());
           review.setDescription(updateReview.getDescription());
           review.setRating(updateReview.getRating());
           review.setCompanyId(updateReview.getCompanyId());
           reviewRepository.save(review);
           return true;
       }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteReview( Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);

        if(review != null){
            reviewRepository.delete(review);
            return true;
        }
        else{
            return false;
        }

    }
}
