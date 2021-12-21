package com.voductai.blog_app.controller;

import com.voductai.blog_app.model.Categorise;
import com.voductai.blog_app.service.ICategoriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CategoriseController {
    @Autowired
    private ICategoriseService categoriseService;
    @GetMapping("/categorise")
    public ModelAndView listProvince() {
        Iterable< Categorise > categoriseList = categoriseService.findAll();
        ModelAndView modelAndView = new ModelAndView("/categorise/list", "categoriseList", categoriseList);
        return modelAndView;
    }
    @GetMapping("/create-categorise")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/categorise/create");
        modelAndView.addObject("categorise", new Categorise());
        return modelAndView;
    }

    @PostMapping("/create-categorise")
    public ModelAndView saveProvince(@ModelAttribute("categorise") Categorise categorise) {
        categoriseService.save(categorise);

        ModelAndView modelAndView = new ModelAndView("/categorise/create");
        modelAndView.addObject("categorise", new Categorise());
        modelAndView.addObject("message", "New categorise created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-categorise/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Optional<Categorise> categorise = categoriseService.findById(id);
        if (categorise.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/categorise/edit");
            modelAndView.addObject("categorise", categorise.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-categorise")
    public ModelAndView updateProvince(@ModelAttribute("categorise") Categorise categorise) {
        categoriseService.save(categorise);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("categorise", categorise);
        modelAndView.addObject("message", "Categorise updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-categorise/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Optional<Categorise> categorise = categoriseService.findById(id);
        if (categorise.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/categorise/delete");
            modelAndView.addObject("categorise", categorise.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-categorise")
    public String deleteProvince(@ModelAttribute("categorise") Categorise categorise) {
        categoriseService.remove(categorise.getId());
        return "redirect:categorise";
    }
}
