package com.example.ReviewMS.Reviews.messaging;

import com.example.ReviewMS.Reviews.Review;
import com.example.ReviewMS.Reviews.dto.ReviewMessge;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ReviewMessageProduce {

    public final RabbitTemplate rabbitTemplate;

    public ReviewMessageProduce(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Review review){
        ReviewMessge reviewMessge = new ReviewMessge();
        reviewMessge.setId(review.getId());
        reviewMessge.setDescription(review.getDescription());
        reviewMessge.setTitile(review.getDescription());
        reviewMessge.setRating(review.getRating());
        reviewMessge.setConpanyId(review.getCompanyId());
        rabbitTemplate.convertAndSend("companyRatingQueue" , reviewMessge);
    }
}
