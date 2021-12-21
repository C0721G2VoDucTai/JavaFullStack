package com.example.test.service.impl;

import com.example.test.model.Movies;
import com.example.test.repository.IMoviesRepository;
import com.example.test.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MoviesService implements IMoviesService {
    @Autowired
    private IMoviesRepository moviesRepository;

//    @Override
//    public Page< Movies > findAllBlogByFilmId(Integer filmId, Pageable pageable) {
//        return moviesRepository.findMoviesByFilmId(pageable,filmId);
//    }

    @Override
    public Page< Movies > findByFilm(Pageable pageable, String film) {
//        return moviesRepository.findAllByFilm_Name(film, pageable);
        return moviesRepository.findAllByFilm(film, pageable);
    }

//    @Override
//    public Page< Movies > searchByName(Pageable pageable,int filmId) {
//        return moviesRepository.findMoviesByFilmId(pageable, filmId);
//    }

    @Override
    public Page< Movies > findAll(Pageable pageable) {
        return moviesRepository.findAll(pageable);
    }

    @Override
    public Iterable< Movies > findAll() {
        return moviesRepository.findAll();
    }

    @Override
    public Optional< Movies > findById(String id) {
        return moviesRepository.findById(id);
    }

    @Override
    public void save(Movies movies) {
        moviesRepository.save(movies);
        for(Movies temp : moviesRepository.findAll()){
            if(temp.getName().equals(movies.getName())){

            }
        }
    }

    @Override
    public void remove(String id) {
        moviesRepository.deleteById(id);
    }
}
