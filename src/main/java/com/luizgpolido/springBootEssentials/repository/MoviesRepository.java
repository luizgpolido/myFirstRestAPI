package com.luizgpolido.springBootEssentials.repository;

import com.luizgpolido.springBootEssentials.domain.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository <Movies, Long>{

}
