package com.example.CompanyMS.Company.messaging;

import com.example.CompanyMS.Company.CompanyService;
import com.example.CompanyMS.Company.dto.ReviewMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageConsumer {
    private final CompanyService companyService;

    public ReviewMessageConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RabbitListener(queues = "companyRatingQueue")
    public void consumerMessage(ReviewMessage reviewMessage) {
        System.out.println("Received message: " + reviewMessage.getDescription());
        System.out.println("Company ID: " + reviewMessage.getCompanyId());
        companyService.updateCompanyRating(reviewMessage);
    }
}