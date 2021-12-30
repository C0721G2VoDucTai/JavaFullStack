package com.voductai.blog_app.service;

import com.voductai.blog_app.model.Blog;
import com.voductai.blog_app.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Transactional
@Service
public class  BlogService implements IBlogService {
@Autowired
private IBlogRepository blogRepository;

    @Override
    public Iterable< Blog > findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional< Blog > findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }


    @Override
    public Page< Blog > findAllByName(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page< Blog > fillAllByCategoriseId(Integer categoriseId, Pageable pageable) {
        return blogRepository.findAllByCategorise_Id(categoriseId,pageable);
    }

    @Override
    public Page< Blog > findAllByTwo(String name, Integer categoriseId, Pageable pageable) {
        return blogRepository.findAllByNameAndCategorise_Id(name,categoriseId,pageable);
    }

    @Override
    public Page< Blog > findAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
