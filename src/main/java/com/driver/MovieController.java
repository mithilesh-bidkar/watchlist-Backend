package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);

        return new ResponseEntity<>("Successfully", HttpStatus.OK);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);

        return new ResponseEntity("Director added successfully",HttpStatus.OK);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("m") String movieName ,@RequestParam("d") String dirName){
        movieService.addMovieDirectorPair(movieName,dirName);

        return  new ResponseEntity("Pair created successfully",HttpStatus.OK);
    }


}
