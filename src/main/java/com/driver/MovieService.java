package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String dirName) {
        movieRepository.addMovieDirectorPair(movieName,dirName);
    }

    public Movie getMovieByName(String movieName) {

       return movieRepository.getMovieByName(movieName);

    }

    public Director getDirectorName(String directorName) {

        return movieRepository.getDirectorName(directorName);
    }

    public List<String> getMoviesByDirectorName(String dirName) {

        return movieRepository.getMoviesByDirectorName(dirName);
    }

    public List<String> findAllMovies() {

        return  movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String dirName) {
        movieRepository.deleteDirectorByName(dirName);
    }

    public void deleteAllDirectors() {

        movieRepository.deleteAllDirectors();
    }
}
