package com.voductai.blog_app.controller;

import com.voductai.blog_app.model.Blog;
import com.voductai.blog_app.model.Categorise;
import com.voductai.blog_app.service.IBlogService;
import com.voductai.blog_app.service.ICategoriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private ICategoriseService categoriseService;

    @ModelAttribute("categoriseList")
    public Iterable< Categorise > categoriseList() {
        Iterable< Categorise > categoriseList = categoriseService.findAll();
        return categoriseList;
    }

    @Autowired
    private IBlogService blogService;

    @GetMapping("/blog")
    public String showListBlog(Model model,
                               Optional <String> name,
                               Optional< Integer > categoriseId,
                               @PageableDefault(size = 10) Pageable pageable) {
        if (!name.isPresent()) {
            if (categoriseId.isPresent()) {
                model.addAttribute("blogList", blogService.findAllBlogByCategoriseId(categoriseId.get(), pageable));
            } else {
                model.addAttribute("blogList", blogService.findAllBlogs(pageable));
            }
        } else {
            model.addAttribute("blogList", blogService.findBlogsByNameContaining(name.get(), pageable));
            model.addAttribute("name", name.get());
        }
//        model.addAttribute("categoriseList", categoriseService.findAll());
        return "blog/temp-list";

    }

    //           @GetMapping("/blog")
//    public ModelAndView showlistBlog() {
//        Iterable< Blog > blogList = blogService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/blog/list");
//        modelAndView.addObject("blogList", blogList);
//        return modelAndView;
//    }
    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("blog") Blog blog,
                                     BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            blogService.save(blog);
            modelAndView.addObject("blog", new Blog());
            modelAndView.addObject("message", "New blog created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Optional< Blog > blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Optional< Blog > blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:blog";
    }
}

