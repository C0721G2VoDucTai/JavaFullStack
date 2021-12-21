package com.example.test.service;

import com.example.test.model.Film;

import java.util.Optional;
public interface IFimService {
    Iterable< Film > findAll();

    Optional<Film> findById(Integer id);

    void save(Film movies);

    void remove(Integer id);
}
