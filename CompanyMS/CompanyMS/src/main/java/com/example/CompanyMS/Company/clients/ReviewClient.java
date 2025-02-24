package com.example.CompanyMS.Company.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("REVIEW-SERVICE")
public interface ReviewClient {


    @GetMapping("/reviews/averageRatting")
    Double getAverageRatingForCompany(@RequestParam("companyId") Long companyId);
}
