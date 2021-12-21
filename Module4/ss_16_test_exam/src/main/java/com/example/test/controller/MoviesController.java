package com.example.test.controller;

import com.example.test.model.Film;
import com.example.test.model.Movies;
import com.example.test.repository.IMoviesRepository;
import com.example.test.service.IFimService;
import com.example.test.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private IMoviesService moviesService;
    @Autowired
    private IMoviesRepository moviesRepository;
    @Autowired
    private IFimService filmService;

    @ModelAttribute("filmList")
    public Iterable< Film > filmList(Model model) {
        return filmService.findAll();
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping
    public String showList(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page< Movies > moviesPage = moviesService.findAll(pageable);
        model.addAttribute("moviesPage", moviesPage);
        return "a/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("movies", new Movies());
        return "a/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute("movies") Movies movies,
                                 BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "a/create";
        } else {
            if (moviesRepository.existsByName(movies.getName())) {
                model.addAttribute("msg", "duplicate name");
                return "a/create";
            } else {
                moviesService.save(movies);
                redirectAttributes.addFlashAttribute("message", "Create successfully");
                return "redirect:/movies";
            }
        }
    }

    @GetMapping("/delete/{id}")
    public String showDetailMovies(@PathVariable String id, Model model) {
        Optional< Movies > movies = moviesService.findById(id);
        model.addAttribute("movies", movies.get());
        return "a/delete";
    }

    @PostMapping("/delete")
    public String deleteMovies(@RequestParam String id,
                               Model model) {
        moviesService.remove(id);
        return "redirect:/movies";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable String id, Model model) {
        Optional< Movies > movies = moviesService.findById(id);
        model.addAttribute("movies", movies.get());
        return "a/detail";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable String id, Model model) {
        Optional< Movies > movies = moviesService.findById(id);
        if (movies.isPresent()) {
            model.addAttribute("movies", movies);
            return "a/edit";
        } else {
            return "error.404";
        }
    }

    @PostMapping("/edit")
    public String editMovies(@ModelAttribute("movies") Movies movies,
                             Model model, RedirectAttributes ra) {
        moviesService.save(movies);
        ra.addFlashAttribute("message", "Edit movies successfully");
        return "redirect:/movies";
    }

    @PostMapping("/search")
    public String searchByName(@RequestParam @PageableDefault(size = 5) String film, Pageable pageable, Model model) {
        System.out.println(film);
        Page< Movies > moviesPage = moviesService.findByFilm(pageable, film);
        model.addAttribute("moviesPage", moviesPage);
        return "a/list";
    }
}
