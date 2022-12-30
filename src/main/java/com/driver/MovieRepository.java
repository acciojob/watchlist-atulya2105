package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    // add in the database


    //List of Movie

    HashMap<String, Movie> listOfMovies = new HashMap<>();

    // List od Director

    HashMap<String,Director> listOfDirector = new HashMap<>();

    // List of Director and movie pair
    HashMap<String,List<String>> db = new HashMap<>();

    String addMovie(Movie movie){
        listOfMovies.put(movie.getName(),movie);
        return "New movie has been added Successfully";
    }

    String addDirector(Director director){
        listOfDirector.put(director.getName(),director);
        return "New director has been added successfully";
    }
    String addMovieDirectorPair(String director,String movie){
        if(listOfMovies.containsKey(director) && listOfDirector.containsKey(movie)){
            if(db.containsKey(director)){
                List<String > ls = db.get(director);
                ls.add(movie);
                db.put(director,ls);
            }else{
                List<String> ls = new ArrayList<>();
                ls.add(movie);
                db.put(director,ls);
            }
        }
        return "Successfully added director and movie pair in the database";
    }


    Movie getMovieByName(String name){

        return listOfMovies.get(name);
    }
    Director getDirectorByName(String name){

        return listOfDirector.get(name);
    }

    List<String> getMoviesByDirectorName(String  director){
        if(db.containsKey(director)){
            return db.get(director);
        }
        return null;
    }

    List<String > findAllMovies(){
        List<String> ans = new ArrayList<>();
        for( String s : listOfMovies.keySet()){
            ans.add(s);
        }
        return ans;
    }

    String deleteDirectorByName(String  director){
        // delete from the director database
        listOfDirector.remove(director);

        // if that director is present in the pair database, so we have  to delete the respective movies as well
        // we can get the movies from the pair of the database
        if(db.containsKey(director)){

            // get the movies from the database
            List<String> ls = db.get(director);
            //iterate the movie database and if the movie is present in the database so we will remove the movie from there as well as.
            for(String l:ls){
                if(listOfMovies.containsKey(l)){
                    listOfMovies.remove(l);
                }
            }

            // delete the director from the pair database
            db.remove(director);

        }
        return "Successfully deleted";
    }
    String deleteAllDirectors(){
        listOfDirector = new HashMap<>();

        for(String s : db.keySet()){
            List<String> ls  = db.get(s);
            for(String st : ls){
                if(listOfMovies.containsKey(st)){
                    listOfMovies.remove(st);
                }
            }
        }

        db = new HashMap<>();
        return "successfully all the director have been deleted from tha database";
    }
}
