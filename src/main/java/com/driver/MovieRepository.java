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

    public Movie getMovieByName(String movieName) {

        return movieDB.get(movieName);
    }

    public Director getDirectorName(String directorName) {

        return directorDB.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String dirName) {

        return pairDB.get(dirName);
    }

    public List<Movie> findAllMovies() {

        List<Movie> list = new ArrayList<>();

        for(Movie movie : movieDB.values()){
            list.add(movie);
        }

        return list;
    }


    public void deleteDirectorByName(String dirName) {

        if (directorDB.containsKey(dirName)){
            directorDB.remove(dirName);
        }
        if(pairDB.containsKey(dirName)){
            List<String> list = pairDB.get(dirName);
            for(String movie : list){
                movieDB.remove(movie);
            }
            pairDB.remove(dirName);
        }

    }

    public void deleteAllDirectors() {

        for (String d : directorDB.keySet()){
            directorDB.remove(d);
        }
        for (String d : pairDB.keySet()){
            List<String> list = pairDB.get(d);

            for (String movie : list){
                movieDB.remove(movie);
            }
            pairDB.remove(d);
        }

    }
}
