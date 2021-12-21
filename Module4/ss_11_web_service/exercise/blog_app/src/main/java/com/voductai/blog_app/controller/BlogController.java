package com.voductai.blog_app.controller;

import com.voductai.blog_app.model.Blog;
import com.voductai.blog_app.model.Categorise;
import com.voductai.blog_app.service.IBlogService;
import com.voductai.blog_app.service.ICategoriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/blog")
public class BlogController {
    @Autowired
    private ICategoriseService categoriseService;
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity< Iterable< Blog > > showListBlog() {
        List< Blog > blogList = (List< Blog >) blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/categorise")
    public ResponseEntity< Iterable< Categorise > > categoriseShowList() {
        List< Categorise > categoriseList = (List< Categorise >) categoriseService.findAll();
        if (categoriseList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoriseList, HttpStatus.OK);
    }

    @GetMapping("/categorise/{id}")
    public ResponseEntity< Iterable< Blog > > showBlogOfCategorise(@PathVariable Integer id) {
        Optional< Categorise > categorise = categoriseService.findById(id);
        if (categorise.isPresent()) {
            List< Blog > blogList = new ArrayList<>();
            for (Blog blog : categorise.get().getBlogList()) {
                blogList.add(blog);
            }
            return new ResponseEntity<>(blogList, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity< Blog > showBlogDetail(@PathVariable Integer id) {
        Optional< Blog > blogs = blogService.findById(id);
        if (blogs.isPresent()) {
            Blog blog = blogs.get();
            return new ResponseEntity<>(blog, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

