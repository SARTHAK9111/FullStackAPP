package com.example.JobApp.Reviews;

import org.springframework.stereotype.Service;

import java.util.*;


public interface ReviewService {

    List<Review> getAllReviews(Long comapnayID);


    boolean addReview(Long companyId, Review review);
    Review getReview(Long companyId ,Long reviewId);
    boolean updateReview(Long companyId , Long reviewId ,Review review );

    boolean deleteReview(Long companyId, Long reviewId);
}
