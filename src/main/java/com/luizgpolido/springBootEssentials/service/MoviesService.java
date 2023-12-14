package com.luizgpolido.springBootEssentials.service;

import com.luizgpolido.springBootEssentials.domain.Movies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class MoviesService {

    private static List<Movies> movies;

    static {movies = new ArrayList<>(List.of(new Movies(1L, "Harry Potter" , "Fantasy"), new Movies(2L, "Need For Speed" , "Action")));}
    public List<Movies> moviesList(){
        return movies;
    }

    public Movies findById(long id){
        return movies.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie not found"));
    }

    public Movies save (Movies movie){
        movie.setId(ThreadLocalRandom.current().nextLong(3, 100));
        movies.add(movie);
        return movie;
    }
}
