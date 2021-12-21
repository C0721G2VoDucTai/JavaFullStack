package com.example.test.repository;

import com.example.test.model.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMoviesRepository extends JpaRepository< Movies, String > {
    Page< Movies > findAllByFilm_Name(String film, Pageable pageable);

    //
//    @Query(value = "select m.id, m.`name`,m.date,m.film_id,m.quantity\n" +
//            " from movies m\n" +
//            " join film f\n" +
//            " where (m.film_id = f.id) and (f.`name` like concat('%',:film,'%'))", nativeQuery = true)
    @Query(value = " select m.id, m.`name`,m.date,m.film_id,m.quantity\n" +
            " from movies m\n" +
            " join film f on m.film_id = f.id\n" +
            " where f.`name` like concat('%',:film,'%')", nativeQuery = true)
    Page< Movies > findAllByFilm(@Param("film") String film, Pageable pageable);
    Boolean existsByName(String name);
}
