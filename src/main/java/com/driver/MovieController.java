package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    // add movie
    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movies added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully",HttpStatus.CREATED);
    }

    @PutMapping("/add_director_movie")
    public ResponseEntity<String > addMovieDirectorPair(@RequestParam String director,@RequestParam String movie){

        movieService.addMovieDirectorPair(director,movie);
        return new ResponseEntity<>("New movie-director pair added successfully",HttpStatus.CREATED);

    }

    @GetMapping("/get_movie_by_name")
    public ResponseEntity<Movie> getMovieByName(@RequestParam String name){
        Movie result = movieService.getMovieByName(name);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/get_director_by_name")
    public ResponseEntity getDirectorByName(@RequestParam String name){
        Director result = movieService.getDirectorByName(name);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("get_movie_list_by_director_name")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@RequestParam String  director){
        List<String> re = movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(re,HttpStatus.CREATED);
    }

    @GetMapping("/get_all_the_movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.CREATED);
    }


    @DeleteMapping("delete_Movie")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieService.deleteDirectorByName(director);
        return new ResponseEntity<>(director +" removed successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("delete_all_director")
    public  ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("director deleted successfully",HttpStatus.CREATED);
    }
}
