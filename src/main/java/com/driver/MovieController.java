package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);

        return new ResponseEntity<>("Movie Added Successfully", HttpStatus.OK);
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

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String movieName ){
       Movie movie = movieService.getMovieByName(movieName);

        return new ResponseEntity(movie,HttpStatus.FOUND);

    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName (@PathVariable("name") String directorName){
        Director director = movieService.getDirectorName(directorName);

        return  new ResponseEntity(director,HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String dirName){
        List<String> list = movieService.getMoviesByDirectorName(dirName);

        return new ResponseEntity(list,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> list = movieService.findAllMovies();

        return  new ResponseEntity(list,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("d") String dirName){
        movieService.deleteDirectorByName(dirName);
        return new ResponseEntity("Director Name Deleted Successfully",HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();

        return new ResponseEntity("All Directors Deleted",HttpStatus.ACCEPTED);
    }



}
