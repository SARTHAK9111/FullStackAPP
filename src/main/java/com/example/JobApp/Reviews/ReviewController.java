package com.example.JobApp.Reviews;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);

    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
         boolean flag =reviewService.addReview(companyId ,review);

        if( flag){
            return new ResponseEntity<>("Review Added Succesfully" , HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review Not Saved" , HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId , @PathVariable Long reviewId){

        return  new ResponseEntity<>(reviewService.getReview(companyId, companyId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId ,@PathVariable Long reviewId,@RequestBody Review review){
        boolean flag = reviewService.updateReview(companyId ,reviewId ,review);

        if(flag){
            return new ResponseEntity<>("Review update Successfulli" , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not update", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReeview(@PathVariable Long companyId , @PathVariable Long reviewId){
        boolean flag =  reviewService.deleteReview(companyId,reviewId);
        if(flag){
            return new ResponseEntity<>("Review Delete Successfulli" , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not update", HttpStatus.NOT_FOUND);
        }
    }
}
