package com.example.test.repository;

import com.example.test.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFilmRepository extends JpaRepository < Film, Integer> {
}
