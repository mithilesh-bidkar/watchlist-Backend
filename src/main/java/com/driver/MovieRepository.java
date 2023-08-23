package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDB = new HashMap<>();
    HashMap<String,Director> directorDB = new HashMap<>();

    HashMap<String, List<String>> pairDB =  new HashMap<>();

    public void addMovie(Movie movie) {
        movieDB.put(movie.getName(),movie);
    }

    public void addDirector(Director director) {
        directorDB.put(director.getName(),director);
    }

    public void addMovieDirectorPair(String movieName, String dirName) {

        if(movieDB.containsKey(movieName) && directorDB.containsKey(dirName)){
            List<String> list = pairDB.getOrDefault(dirName,new ArrayList<>());
            list.add(movieName);
            pairDB.put(dirName,list);
        }
    }
}
