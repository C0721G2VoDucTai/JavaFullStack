package voductai.furama_resort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import voductai.furama_resort.model.employee.*;
import voductai.furama_resort.service.employee.*;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IUserService userService;

    @ModelAttribute("positionList")
    public Iterable< Position > positionList() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public Iterable< EducationDegree > educationDegreeList() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisionList")
    public Iterable< Division > divisionList() {
        return divisionService.findAll();
    }

    @ModelAttribute("userList")
    public Iterable< User > userList() {
        return userService.findAll();
    }

//    @GetMapping("/test")
//    public  String test(@RequestParam(name = "page", defaultValue = "0") int page,
//                        @RequestParam(value = "sortField", defaultValue = "name") String sortField,
//                        @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection,
//                        Optional< String > keyword,
//                        Model model){
//        int size = 5;
//        Page< Employee >  employeePage = employeeService.findAllEmployee(page, size, sortField, sortDirection);
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("sortDirection", sortDirection);
//        model.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
//        model.addAttribute("employeePage", employeePage);
//        return "test/tables";
//    }
    @GetMapping
    public String showListEmployee(@RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "sortField", defaultValue = "name") String sortField,
                                   @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection,
                                   Optional< String > keyword,
                                   Optional<Integer> positionId,
                                   Model model) {
        int size = 5;
        Page< Employee > employeePage =null;
        if(!keyword.isPresent() || keyword.get().equals("")) {
            if(!positionId.isPresent()){
                System.out.println("testA");
                employeePage = employeeService.findAllEmployee(page, size, sortField, sortDirection);
            }else {
                System.out.println("B");
                employeePage =employeeService.findEmployeeByPositionId(page,size,sortField,sortDirection,positionId.get());
            }
        }else {
            if(!positionId.isPresent()){
                System.out.println("C");
                employeePage = employeeService.findEmployeeByKeyword(page,size,sortField,sortDirection,keyword.get());
                model.addAttribute("keyword", keyword.get());

            }else {
                employeePage = employeeService.findEmployeeByKeyword(page,size,sortField,sortDirection,keyword.get());
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
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model) {
        Optional< Employee > employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("delete/{id}")
    public String showDetail(@PathVariable Integer id, Model model) {
        Optional< Employee > employee = employeeService.findById(id);
        model.addAttribute("employee", employee.get());
        return "employee/delete";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Integer id, Model model) {
        employeeService.remove(id);
        return "redirect:/employee";
    }

//    @PostMapping("/search")
//    public String search(@RequestParam(name = "page", defaultValue = "0") int page,
//                         @RequestParam(value = "sortField", defaultValue = "name") String sortField,
//                         @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection,
//                         Optional< String > keyword,
//                         Model model) {
//        int size = 5;
//        Page< Employee > employeePage = employeeService.findEmployeeByKeyword(page, size, sortField, sortDirection, keyword.get());
//        if (employeePage.isEmpty()) {
//            return "error.404";
//        } else {
//            model.addAttribute("employeePage", employeePage);
//            return "employee/list";
//        }
//    }
}
