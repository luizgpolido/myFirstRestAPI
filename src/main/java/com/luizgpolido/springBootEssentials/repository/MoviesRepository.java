package com.luizgpolido.springBootEssentials.repository;

import com.luizgpolido.springBootEssentials.domain.Movies;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository {
    List<Movies> listAll();
}
