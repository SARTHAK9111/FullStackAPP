package com.example.JobMS.Jobs.clients;

import com.example.JobMS.Jobs.External.Review;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name ="REVIEW-SERVICE")
public interface ReviewClient {
    @GetMapping("/reviews")
    List<Review> getReview(@RequestParam("companyId") Long companyId);
}
