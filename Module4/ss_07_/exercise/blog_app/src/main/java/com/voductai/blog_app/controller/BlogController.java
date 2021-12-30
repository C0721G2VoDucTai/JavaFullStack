package com.voductai.blog_app.controller;

import com.voductai.blog_app.model.Blog;
import com.voductai.blog_app.model.Categorise;
import com.voductai.blog_app.service.IBlogService;
import com.voductai.blog_app.service.ICategoriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
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
    public String test(){
        return "test/test";
    }
    @GetMapping()
    public String showListBlog(@PageableDefault(size = 5) Pageable pageable,
                                   Optional< String > name,
                                   Optional< Integer > categoriseId,
                                   Model model) {
        Page< Blog > blogPage = null;
        if (!categoriseId.isPresent()) {
            if (!name.isPresent() || name.get().equals("")) {
                System.out.println("testA");
                blogPage = blogService.findAllBlogs(pageable);
            } else {
                System.out.println("B");
                blogPage = blogService.findAllByName(name.get(), pageable);
                model.addAttribute("name", name.get());
            }
        } else {
            if (!name.isPresent() || name.get().equals("")) {
                System.out.println("C");
                blogPage = blogService.fillAllByCategoriseId(categoriseId.get(), pageable);
                model.addAttribute("categoriseId", categoriseId.get());

            } else {
                blogPage = blogService.findAllByTwo(name.get(), categoriseId.get(), pageable);
                model.addAttribute("categoriseId", categoriseId.get());
                model.addAttribute("name", name.get());
            }
        }
        model.addAttribute("blogPage", blogPage);
        return "blog/list2";

    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
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
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Integer id, Model model) {
        Optional< Blog > blog = blogService.findById(id);
        if (blog.isPresent()) {
            model.addAttribute("blog", blog.get());
            return "blog/detail";
        } else {
            return "error.404";
        }
    }
    @GetMapping("/edit/{id}")
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

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
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

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id) {
        blogService.remove(id);
        return "redirect:/blog";
    }
}

