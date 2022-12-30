package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    // add movie
    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String result = movieService.addMovie(movie);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/add_director")
    public ResponseEntity addDirector(@RequestBody() Director director){
        String result = movieService.addDirector(director);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/add_director_movie")
    public ResponseEntity addMovieDirectorPair(@RequestBody() Director director,Movie movie){

        String result = movieService.addMovieDirectorPair(director,movie);
        return new ResponseEntity<>(result,HttpStatus.OK);

    }

    @GetMapping("/get_movie_by_name")
    public ResponseEntity getMovieByName(@RequestParam("name") String name){
        Movie result = movieService.getMovieByName(name);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/get_director_by_name")
    public ResponseEntity getDirectorByName(String name){
        Director result = movieService.getDirectorByName(name);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("get_movie_list_by_director_name")
    public ResponseEntity getMoviesByDirectorName(@RequestBody() Director director){
        List<Movie> re = movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(re,HttpStatus.OK);
    }

    @GetMapping("/get_all_the_movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK);
    }


    @DeleteMapping("delete_Movie")
    public ResponseEntity<String> deleteDirectorByName(Director director){
        return new ResponseEntity<>(movieService.deleteDirectorByName(director),HttpStatus.OK);
    }

    @DeleteMapping("delete_all_director")
    public  ResponseEntity deleteAllDirectors(){
        return new ResponseEntity<>(movieService.deleteAllDirectors(),HttpStatus.OK);
    }
}
