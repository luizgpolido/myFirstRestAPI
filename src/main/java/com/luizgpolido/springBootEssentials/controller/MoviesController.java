package com.luizgpolido.springBootEssentials.controller;

import com.luizgpolido.springBootEssentials.domain.Movies;
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
        return new ResponseEntity<>(moviesService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movies> save(@RequestBody Movies movies){
        return new ResponseEntity<>(moviesService.save(movies), HttpStatus.CREATED);
    }
}
