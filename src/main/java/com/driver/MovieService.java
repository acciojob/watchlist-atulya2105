package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    // add  movie
     String addMovie(Movie movie){
        String result = movieRepository.addMovie(movie);
        return result;

    }

    String addDirector(Director director){
         return movieRepository.addDirector(director);
    }
    String addMovieDirectorPair(Director director,Movie movie){
         return movieRepository.addMovieDirectorPair(director,movie);
    }
    Movie getMovieByName(String name){
         return movieRepository.getMovieByName(name);
    }

    Director getDirectorByName(String name){
         return movieRepository.getDirectorByName(name);
    }
    List<Movie> getMoviesByDirectorName(Director director){
         return  movieRepository.getMoviesByDirectorName(director);
    }

    List<Movie> findAllMovies(){
         return movieRepository.findAllMovies();
    }

    String deleteDirectorByName(Director director){
         return movieRepository.deleteDirectorByName(director);
    }

    String deleteAllDirectors(){
         return movieRepository.deleteAllDirectors();
    }
}
