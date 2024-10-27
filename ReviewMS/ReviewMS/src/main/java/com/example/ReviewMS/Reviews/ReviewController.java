package com.example.ReviewMS.Reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam  Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review){
         boolean flag =reviewService.addReview(companyId ,review);

        if( flag){
            return new ResponseEntity<>("Review Added Succesfully" , HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review Not Saved" , HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview( @PathVariable Long reviewId){

        return  new ResponseEntity<>(reviewService.getReview( reviewId), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,@RequestBody Review review){
        boolean flag = reviewService.updateReview(reviewId ,review);

        if(flag){
            return new ResponseEntity<>("Review update Successfulli" , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not update", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReeview( @PathVariable Long reviewId){
        boolean flag =  reviewService.deleteReview(reviewId);
        if(flag){
            return new ResponseEntity<>("Review Delete Successfulli" , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not update", HttpStatus.NOT_FOUND);
        }
    }
}
