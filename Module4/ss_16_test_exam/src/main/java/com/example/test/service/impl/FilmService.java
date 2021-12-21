package com.example.test.service.impl;

import com.example.test.model.Film;
import com.example.test.repository.IFilmRepository;
import com.example.test.service.IFimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FilmService implements IFimService {
    @Autowired
    private IFilmRepository filmRepository;
    @Override
    public Iterable< Film > findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Optional< Film > findById(Integer id) {
        return filmRepository.findById(id);
    }

    @Override
    public void save(Film film) {
        filmRepository.save(film);

    }

    @Override
    public void remove(Integer id) {
        filmRepository.deleteById(id);
    }
}
