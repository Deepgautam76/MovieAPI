package dev.kamal.movies.Controllers;

import dev.kamal.movies.Models.Review;
import dev.kamal.movies.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//cros origin error solving
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/reviews")
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
        //Console output
        System.out.println("This is the payload"+payload);
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
    }
    @GetMapping("/reviews")
    public  ResponseEntity<List<Review>> allReview(){
        return  new ResponseEntity<List<Review>>(reviewService.allreview(),HttpStatus.OK);
    }

}
