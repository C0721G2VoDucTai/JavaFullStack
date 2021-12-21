package com.example.test.service;

import com.example.test.model.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IMoviesService {
//    Page< Movies > findAllBlogByFilmId(@Param("id")Integer filmId, Pageable pageable);
    Page<Movies> findByFilm(Pageable pageable, @Param("film") String film);
//    Page<Movies> searchByName(Pageable pageable,int filmId);
    Page<Movies> findAll(Pageable pageable);
    Iterable< Movies > findAll();
    Optional<Movies> findById(String id);

    void save(Movies movies);

    void remove(String id);
}
