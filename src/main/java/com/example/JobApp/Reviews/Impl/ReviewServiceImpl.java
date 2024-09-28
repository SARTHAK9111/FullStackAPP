package com.example.JobApp.Reviews.Impl;

import com.example.JobApp.Company.Company;
import com.example.JobApp.Company.CompanyService;
import com.example.JobApp.Reviews.Review;
import com.example.JobApp.Reviews.ReviewRepository;
import com.example.JobApp.Reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService CompanyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService CompanyService) {
        this.reviewRepository = reviewRepository;
        this.CompanyService = CompanyService;
    }

    @Override
    public List<Review> getAllReviews(Long CompnayID) {

        List<Review> reviews = reviewRepository.findByCompanyId(CompnayID);
        return reviews;
    }

    @Override
    public boolean addReview(Long compantId, Review review) {
        Company company = CompanyService.getCompanyById(compantId);

        if(company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true ;
        }else{
            return false;
        }
    }

    @Override
    public Review getReview(Long companyId, Long reviewId){
        List<Review> reviews =reviewRepository.findByCompanyId(companyId);

        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);

    }

    @Override
    public  boolean updateReview(Long companyId, Long reviewId, Review updateReview ) {
        if(CompanyService.getCompanyById(companyId)!= null){
            updateReview.setCompany(CompanyService.getCompanyById(companyId));
            updateReview.setId(reviewId);
            reviewRepository.save(updateReview);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(CompanyService.getCompanyById(companyId)!= null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company= review.getCompany();
            company.getReview().remove(review);
            review.setCompany(null);
            CompanyService.updateCompany(company , companyId);
            reviewRepository.deleteById(reviewId);
            return true;

        }
        else{
            return false;
        }

    }
}
