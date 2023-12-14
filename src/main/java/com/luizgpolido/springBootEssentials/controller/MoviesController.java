package com.luizgpolido.springBootEssentials.controller;

import com.luizgpolido.springBootEssentials.domain.Movies;
import com.luizgpolido.springBootEssentials.requests.MoviePostRequestBody;
import com.luizgpolido.springBootEssentials.requests.MoviePutRequestBody;
import com.luizgpolido.springBootEssentials.service.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public ResponseEntity<List<Movies>> list(){
        return new ResponseEntity<>(moviesService.moviesList(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Movies> listById(@PathVariable long id){
        return new ResponseEntity<>(moviesService.findByIdOrThrowsException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movies> save(@RequestBody MoviePostRequestBody moviePostRequestBody){
        return new ResponseEntity<>(moviesService.save(moviePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        moviesService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody MoviePutRequestBody moviePutRequestBody){
        moviesService.update(moviePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
