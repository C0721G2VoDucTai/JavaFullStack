package voductai.furama_resort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import voductai.furama_resort.model.customer.Customer;
import voductai.furama_resort.model.customer.CustomerType;
import voductai.furama_resort.model.employee.Employee;
import voductai.furama_resort.service.customer.ICustomerService;
import voductai.furama_resort.service.customer.ICustomerTypeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypeList")
    public Iterable< CustomerType > customerTypeList(Model model) {
        return customerTypeService.findAll();
    }

//    @GetMapping
//    public String showListCustomer(@PageableDefault(size = 10) Pageable pageable, Model model) {
//        Sort sort = Sort.by("name").ascending();//sắp xếp
//        Page< Customer > customerPage = customerService.findAll(pageable);
//        model.addAttribute("customerPage", customerPage);
//        return "customer/list-use";
//    }

    @GetMapping
    public String showListCustomer(@RequestParam(name = "page", defaultValue = "0") int page,
                                   Optional< String > keyword,
                                   Optional< Integer > customerTypeId,
                                   Model model) {
        int size = 5;
        Page< Customer > customerPage =null;
        if(!keyword.isPresent() || keyword.get().equals("")) {
            if(!customerTypeId.isPresent()){
                System.out.println("testA");
                customerPage = customerService.findAll(page, size);
            }else {
                System.out.println("B");
                customerPage =customerService.findEmployeeByPositionId(page,size,sortField,sortDirection,positionId.get());
            }
        }else {
            if(!positionId.isPresent()){
                System.out.println("C");
                customerPage = customerService.findEmployeeByKeyword(page,size,sortField,sortDirection,keyword.get());
                model.addAttribute("keyword", keyword.get());

            }else {
                customerPage = customerService.findEmployeeByKeyword(page,size,sortField,sortDirection,keyword.get());
                model.addAttribute("keyword", keyword.get());
            }
        }
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
        model.addAttribute("employeePage", employeePage);
        return "employee/list1";

    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                 BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "customer/create";
        } else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Create successfully");
            return "redirect:/customer";
        }
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable String id, Model model) {
        Optional< Customer > customer = customerService.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer);
            return "customer/edit";
        } else {
            return "error.404";
        }
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer,
                               Model model, RedirectAttributes ra) {
        customerService.save(customer);
        ra.addFlashAttribute("message", "Edit customer successfully");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String showDetailCustomer(@PathVariable String id, Model model) {
        Optional< Customer > customer = customerService.findById(id);
        model.addAttribute("customer", customer.get());
        return "customer/delete";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable String id, Model model) {
        Optional< Customer > customer = customerService.findById(id);
        model.addAttribute("customer", customer.get());
        return "customer/detail";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam String id,
                                 Model model) {
        customerService.remove(id);
        return "redirect:/customer";
    }

    @PostMapping("/search")
    public String searchByName(@RequestParam @PageableDefault(size = 5) String name,
                               Model model,
                               Pageable pageable) {
        Page< Customer > customerPage = customerService.searchByName(name, pageable);
        model.addAttribute("customerPage", customerPage);
        return "customer/list";
    }

    @GetMapping("/test")
    public String test() {
        return "test/list";
    }
}
