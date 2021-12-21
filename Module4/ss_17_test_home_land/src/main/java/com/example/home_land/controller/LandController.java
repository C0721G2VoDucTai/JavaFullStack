package com.example.home_land.controller;

import com.example.home_land.model.Customer;
import com.example.home_land.model.Trade;
import com.example.home_land.service.ICustomerService;
import com.example.home_land.service.ITradeService;
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
@RequestMapping("/trade")
public class LandController {
    @Autowired
    private ITradeService tradeService;
    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("customerList")
    public Iterable< Customer > customerList(Model model) {
        return customerService.findAll();
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

//    @GetMapping()
//    public String showListCustomer(@PageableDefault(size = 5) Pageable pageable,
//                                   Optional< String > name,
//                                   Optional< String > serviceType,
//                                   Model model) {
//        Page< Trade > tradePage =null;
//        if(!name.isPresent() || name.get().equals("")) {
//            if(!serviceType.isPresent() || serviceType.get().equals("")){
//                System.out.println("testA");
//                tradePage = tradeService.findAll(pageable);
//            }else {
//                System.out.println("B");
//                tradePage =tradeService.findByServiceType(serviceType.get(),pageable);
//                model.addAttribute("serviceType", serviceType.get());
//            }
//        }else {
//            if(!serviceType.isPresent() || serviceType.get().equals("")){
//                System.out.println("C");
//                tradePage = tradeService.findByCustomerName(name.get(), pageable);
//                model.addAttribute("name", name.get());
//
//            }else {
//                tradePage = tradeService.findByCustomerNameAndServiceType(name.get(), serviceType.get(), pageable);
//                model.addAttribute("name", name.get());
//                model.addAttribute("serviceType", serviceType.get());
//            }
//        }
//        model.addAttribute("tradePage", tradePage);
//        return "a/list";
//
//    }
    @GetMapping()
    public String showListCustomer(@PageableDefault(size = 10) Pageable pageable,
                                   Optional< String > name,
                                   Optional< String > serviceType,
                                   Model model) {
        Page< Trade > tradePage =null;
        if(!serviceType.isPresent() || serviceType.get().equals("")) {
            if(!name.isPresent() || name.get().equals("")){
                System.out.println("testA");
                tradePage = tradeService.findAll(pageable);
            }else {
                System.out.println("B");
                tradePage =tradeService.findByCustomerName(name.get(),pageable);
                model.addAttribute("name", name.get());
            }
        }else {
            if(!name.isPresent() || name.get().equals("")){
                System.out.println("C");
                tradePage = tradeService.findByServiceType(serviceType.get(), pageable);
                model.addAttribute("serviceType", serviceType.get());

            }else {
                tradePage = tradeService.findByCustomerNameAndService(serviceType.get(),name.get(),pageable);
                model.addAttribute("serviceType", serviceType.get());
                model.addAttribute("name", name.get());
            }
        }
        model.addAttribute("tradePage", tradePage);
        return "a/list";

    }
//    @GetMapping
//    public String showList(@PageableDefault(size = 5) Pageable pageable, Model model) {
//        Page< Trade > tradePage = tradeService.findAll(pageable);
//        model.addAttribute("tradePage", tradePage);
//        return "a/list";
//    }

    //
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("trade", new Trade());
        return "a/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute("trade") Trade trade,
                                 BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "a/create";
        } else {
//            if (moviesRepository.existsByName(trade.getName())) {
//                model.addAttribute("msg", "duplicate name");
//                return "a/create";
//            } else {
            tradeService.save(trade);
            redirectAttributes.addFlashAttribute("message", "Create successfully");
            return "redirect:/trade";
        }
    }

    //
    @GetMapping("/delete/{id}")
    public String showDetailMovies(@PathVariable String id, Model model) {
        Optional< Trade > trade = tradeService.findById(id);
        if(trade.isPresent()) {
            model.addAttribute("trade", trade.get());
            return "a/delete";
        } else {
            return "error.404";
        }
    }

    //
    @PostMapping("/delete")
    public String deleteMovies(@RequestParam String id,
                               Model model) {
        tradeService.remove(id);
        return "redirect:/trade";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable String id, Model model) {
        Optional< Trade > trade = tradeService.findById(id);
        if(trade.isPresent()) {
            model.addAttribute("trade", trade.get());
            return "a/detail";
        }else {
            return "error.404";
        }
    }

    //
//    @GetMapping("/edit/{id}")
//    public String showFormEdit(@PathVariable String id, Model model) {
//        Optional< Movies > movies = moviesService.findById(id);
//        if (movies.isPresent()) {
//            model.addAttribute("movies", movies);
//            return "a/edit";
//        } else {
//            return "error.404";
//        }
//    }
//
//    @PostMapping("/edit")
//    public String editMovies(@ModelAttribute("movies") Movies movies,
//                             Model model, RedirectAttributes ra) {
//        moviesService.save(movies);
//        ra.addFlashAttribute("message", "Edit movies successfully");
//        return "redirect:/movies";
//    }
//
//    @PostMapping("/search")
//    public String searchByName(@RequestParam @PageableDefault(size = 5) String name, Pageable pageable, Model model) {
//        Page< Trade > tradePage = tradeService.findByCustomerName(name, pageable);
//        model.addAttribute("tradePage", tradePage);
//        return "a/list";
//    }
//
//    @PostMapping("/searchId")
//    public String searchByCustomerId(@RequestParam @PageableDefault(size = 5) Integer customerId, Pageable pageable, Model model) {
//        Page< Trade > tradePage = tradeService.findByCustomerId(customerId, pageable);
//        model.addAttribute("tradePage", tradePage);
//        return "a/list";
//    }
}
