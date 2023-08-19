package com.example.WatchList;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
     Map<String, Movie> movies = new HashMap<>();
     Map<String, Director> directors = new HashMap<>();
     Map<String, List<String>> directorMovieMap = new HashMap<>();

    public void addMovie(Movie movie) {
        movies.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directors.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        List<String> moviesList = directorMovieMap.get(directorName);
        if (moviesList == null) {
            moviesList = new ArrayList<>();
            directorMovieMap.put(directorName, moviesList);
        }
        moviesList.add(movieName);
    }

    public Movie findMovieByName(String name) {
        return movies.get(name);
    }

    public Director findDirectorByName(String name) {
        return directors.get(name);
    }

    public List<String> findMoviesByDirectorName(String director) {
        return directorMovieMap.getOrDefault(director, new ArrayList<>());
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(movies.keySet());
    }

    public void deleteDirector(String directorName) {
        directors.remove(directorName);
        directorMovieMap.remove(directorName);
    }

    public void deleteAllDirectors() {
        directors.clear();
        directorMovieMap.clear();
    }
}
