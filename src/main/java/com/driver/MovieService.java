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
     public void  addMovie(Movie movie){
        movieRepository.addMovie(movie);


    }

    public void  addDirector(Director director){
          movieRepository.addDirector(director);
    }
     public  void addMovieDirectorPair(String director,String movie){
         movieRepository.addMovieDirectorPair(director,movie);
    }
    Movie getMovieByName(String name){
         return movieRepository.getMovieByName(name);
    }

    Director getDirectorByName(String name){
         return movieRepository.getDirectorByName(name);
    }
    List<String> getMoviesByDirectorName(String director){
         return  movieRepository.getMoviesByDirectorName(director);
    }

    List<String > findAllMovies(){
         return movieRepository.findAllMovies();
    }

     public void deleteDirectorByName(String director){
          movieRepository.deleteDirectorByName(director);
    }

    public  void deleteAllDirectors(){
         movieRepository.deleteAllDirectors();
    }
}
