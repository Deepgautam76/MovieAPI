package dev.kamal.movies.Controllers;

import dev.kamal.movies.Models.Movie;
import dev.kamal.movies.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//This is for the cross org. error solve
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        System.out.println("all Movie"+movieService.allMovies());
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }
//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
       return new ResponseEntity<>(movieService.singleMovie((imdbId)), HttpStatus.OK);
    }

}
