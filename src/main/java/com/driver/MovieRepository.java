package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    // add in the database


    //List of Movies
    List<Movie> listOfMovies = new ArrayList<>();

    // List od Director
    List<Director> listOfDirector = new ArrayList<>();

    // List of Director and movie pair
    HashMap<Director,List> db = new HashMap<>();

    String addMovie(Movie movie){
        listOfMovies.add(movie);
        return "Successfully added movie in the movie list";
    }

    String addDirector(Director director){
        listOfDirector.add(director);
        return "Successfully added director in the director list";
    }
    String addMovieDirectorPair(Director director,Movie movie){
        if(db.containsKey(director)){
            List<Movie> ls = db.get(director);
            db.put(director,ls);
        }else{
            List<Movie> ls = new ArrayList<>();
            ls.add(movie);
            db.put(director,ls);
        }
        return "Successfully added director and movie pair in the database";
    }
    Movie getMovieByName(String name){
        for(Movie m:listOfMovies){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }
    Director getDirectorByName(String name){
        for(Director d:listOfDirector){
            if(d.getName().equals(name)){
                return d;
            }
        }
        return null;
    }

    List<Movie> getMoviesByDirectorName(Director director){
        if(db.containsKey(director)){
            return db.get(director);
        }
        return null;
    }

    List<Movie> findAllMovies(){
        return listOfMovies;
    }

    String deleteDirectorByName(Director director){
        if(db.containsKey(director)){
            db.remove(director);
            return "Successfully director has been deleted from the database";
        }else{
            return "There is no data available";
        }
    }
    String deleteAllDirectors(){
        db.clear();
        return "successfully all the director have been deleted from tha database";
    }
}
