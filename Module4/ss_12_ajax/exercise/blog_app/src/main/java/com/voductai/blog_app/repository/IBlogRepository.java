package com.voductai.blog_app.repository;

import com.voductai.blog_app.model.Blog;
import com.voductai.blog_app.model.Categorise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository< Blog, Integer > {
    Page< Blog > findBlogsByNameContaining(String name, Pageable pageable);

    @Query(value = "select * \n" +
            " from blog b\n" +
            " join categorise  c where b.categorise_id = c.id\n" +
            " and b.categorise_id = :id ", nativeQuery = true)
    Page< Blog > findAllBlogByCategoriseId(@Param("id")Integer categoriseId, Pageable pageable);

}
