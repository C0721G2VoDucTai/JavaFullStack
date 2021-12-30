package com.voductai.blog_app.repository;

import com.voductai.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository< Blog, Integer > {
    Page< Blog > findAllByNameContaining(String name, Pageable pageable);
    Page< Blog > findAllByCategorise_Id(@Param("categoriseId") Integer categoriseId, Pageable pageable);
    Page< Blog > findAllByNameAndCategorise_Id(@Param("name") String name,@Param("categoriseId") Integer categoriseId,
                                                     Pageable pageable);

}
