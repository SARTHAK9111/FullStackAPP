package com.example.ReviewMS.Reviews;

import java.util.List;


public interface ReviewService {

    List<Review> getAllReviews(Long comapnayID);


    boolean addReview(Long companyId, Review review);
    Review getReview(Long reviewId);
    boolean updateReview(Long reviewId ,Review review );

    boolean deleteReview( Long reviewId);
}
