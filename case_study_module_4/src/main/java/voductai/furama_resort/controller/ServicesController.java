package voductai.furama_resort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import voductai.furama_resort.model.service.RentalType;
import voductai.furama_resort.model.service.ServiceType;
import voductai.furama_resort.model.service.Services;
import voductai.furama_resort.service.service.IRentalTypeService;
import voductai.furama_resort.service.service.IServiceService;
import voductai.furama_resort.service.service.IServiceTypeService;

@Controller
@RequestMapping("service")
public class ServicesController {
    @Autowired
    IServiceService serviceService;
    @Autowired
    IServiceTypeService serviceTypeService;
    @Autowired
    IRentalTypeService rentalTypeService;
    @ModelAttribute("serviceTypeList")
    public Iterable< ServiceType > serviceTypeList(){
        return serviceTypeService.findAll();
    }
    @ModelAttribute("rentalTypeList")
    public Iterable< RentalType > rentalTypeList(){
        return rentalTypeService.findAll();
    }
    @GetMapping
    public String showListService(Model model) {
//    Page< Services > servicesPage = serviceService.findAll(pageable);
        Iterable<Services> servicesList = serviceService.findAll();
    model.addAttribute("servicesList",servicesList);
    return "service/list";
    }

}
