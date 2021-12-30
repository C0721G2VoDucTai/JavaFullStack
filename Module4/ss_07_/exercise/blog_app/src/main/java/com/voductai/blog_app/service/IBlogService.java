package com.voductai.blog_app.service;

import com.voductai.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService< Blog > {
    Page< Blog > findAllByName(String name, Pageable pageable);

    Page< Blog > fillAllByCategoriseId(Integer categoriseId, Pageable pageable);

    Page< Blog > findAllByTwo(String name, Integer categoriseId, Pageable pageable);

    Page< Blog > findAllBlogs(Pageable pageable);


}