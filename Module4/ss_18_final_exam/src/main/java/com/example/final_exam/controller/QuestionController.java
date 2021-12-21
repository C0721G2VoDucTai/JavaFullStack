package com.example.final_exam.controller;

import com.example.final_exam.model.Question;
import com.example.final_exam.model.QuestionType;
import com.example.final_exam.service.IQuestionService;
import com.example.final_exam.service.IQuestionTypeService;
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
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IQuestionTypeService questionTypeService;

    @ModelAttribute("questionTypeList")
    public Iterable< QuestionType > questionTypeList(Model model) {
        return questionTypeService.findAll();
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    //    @GetMapping
//    public String showList(@PageableDefault(size = 5) Pageable pageable, Model model) {
//        Page< Question > questionPage = questionService.findAll(pageable);
//        model.addAttribute("questionPage", questionPage);
//        return "a/list";
//    }
    @GetMapping()
    public String showListCustomer(@PageableDefault(size = 5) Pageable pageable,
                                   Optional< String > title,
                                   Optional< Integer > questionTypeId,
                                   Model model) {
        Page< Question > questionPage = null;
        if (!questionTypeId.isPresent()) {
            if (!title.isPresent() || title.get().equals("")) {
                System.out.println("testA");
                questionPage = questionService.findAll(pageable);
            } else {
                System.out.println("B");
                questionPage = questionService.findAllByTitle(title.get(), pageable);
                model.addAttribute("title", title.get());
            }
        } else {
            if (!title.isPresent() || title.get().equals("")) {
                System.out.println("C");
                questionPage = questionService.fillAllByQuestionType(questionTypeId.get(), pageable);
                model.addAttribute("questionTypeId", questionTypeId.get());

            } else {
                questionPage = questionService.findAllByTwo(title.get(), questionTypeId.get(), pageable);
                model.addAttribute("questionTypeId", questionTypeId.get());
                model.addAttribute("title", title.get());
            }
        }
        model.addAttribute("questionPage", questionPage);
        return "a/list";

    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("question", new Question());
        return "a/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute("question") Question question,
                                 BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        question.setDate(LocalDate.now());
        question.setAnswer("");
        question.setStatus(true);
        if (bindingResult.hasErrors()) {
            return "a/create";
        } else {
            questionService.save(question);
            redirectAttributes.addFlashAttribute("message", "Create successfully");
            return "redirect:/question";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDetailMovies(@PathVariable Integer id, Model model) {
        Optional< Question > question = questionService.findById(id);
        if (question.isPresent()) {
            model.addAttribute("question", question.get());
            return "a/delete";
        } else {
            return "error.404";
        }
    }

    //
    @PostMapping("/delete")
    public String deleteMovies(@RequestParam Integer id,
                               Model model) {
        questionService.remove(id);
        return "redirect:/question";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Integer id, Model model) {
        Optional< Question > question = questionService.findById(id);
        if (question.isPresent()) {
            model.addAttribute("question", question.get());
            return "a/detail";
        } else {
            return "error.404";
        }
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model) {
        Optional< Question > question = questionService.findById(id);
        if (question.isPresent()) {
            model.addAttribute("question", question);
            return "a/edit";
        } else {
            return "error.404";
        }
    }

    @PostMapping("/edit")
    public String editMovies(@ModelAttribute("question") Question question,
                             Model model, RedirectAttributes ra) {
        questionService.save(question);
        ra.addFlashAttribute("message", "Edit question successfully");
        return "redirect:/question";
    }

    //    @ExceptionHandler
//    @ExceptionHandler(Exception.class)
//    public String handleException(Model model) {
//        return "/error.404";
//    }

//    @ExceptionHandler(Exception.class)
//    public String handleNumberFormatException(Model model) {
//        return "/error.404";
//    }

}
