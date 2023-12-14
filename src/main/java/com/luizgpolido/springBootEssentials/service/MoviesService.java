package com.luizgpolido.springBootEssentials.service;

import com.luizgpolido.springBootEssentials.domain.Movies;
import com.luizgpolido.springBootEssentials.repository.MoviesRepository;
import com.luizgpolido.springBootEssentials.requests.MoviePostRequestBody;
import com.luizgpolido.springBootEssentials.requests.MoviePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesService {

    private final MoviesRepository moviesRepository;
    public List<Movies> moviesList(){
        return moviesRepository.findAll();
    }

    public Movies findByIdOrThrowsException(long id){
        return moviesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie not found"));
    }

    public Movies save(MoviePostRequestBody moviePostRequestBody){
        return moviesRepository.save(Movies.builder()
                .name(moviePostRequestBody.getName())
                .genre(moviePostRequestBody.getGenre())
                .build());
    }

    public void delete(long id) {
        moviesRepository.delete(findByIdOrThrowsException(id));
    }

    public void update(MoviePutRequestBody moviePutRequestBody) {
        Movies savedMovie = findByIdOrThrowsException(moviePutRequestBody.getId());
        Movies movie = Movies.builder()
                .name(moviePutRequestBody.getName())
                .id(savedMovie.getId())
                .build();

        moviesRepository.save(movie);
    }
}
