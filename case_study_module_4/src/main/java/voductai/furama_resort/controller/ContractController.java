package voductai.furama_resort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import voductai.furama_resort.model.contract.Contract;
import voductai.furama_resort.model.contract.ContractDetail;
import voductai.furama_resort.model.customer.Customer;
import voductai.furama_resort.model.employee.Employee;
import voductai.furama_resort.model.service.Services;
import voductai.furama_resort.service.contract.IContractDetailService;
import voductai.furama_resort.service.contract.IContractService;
import voductai.furama_resort.service.customer.ICustomerService;
import voductai.furama_resort.service.employee.IEmployeeService;
import voductai.furama_resort.service.service.IServiceService;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    IContractService contractService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IServiceService serviceService;
    @Autowired
    IContractDetailService contractDetailService;

    @ModelAttribute("customerList")
    public Iterable< Customer > customerList() {
        return customerService.findAll();
    }

    @ModelAttribute("employeeList")
    public Iterable< Employee > employeeList() {
        return employeeService.findAll();
    }

    @ModelAttribute("serviceList")
    public Iterable< Services > serviceListList() {
        return serviceService.findAll();
    }

    @ModelAttribute("contractDetailList")
    public Iterable< ContractDetail > contractDetailList() {
        return contractDetailService.findAll();
    }

    @GetMapping
    public String showListContract(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page< Contract > contractPage = contractService.findAll(pageable);
        model.addAttribute("contractPage", contractPage);
        return "contract/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }
    @PostMapping("/create")
    public String createContract(@ModelAttribute("contract") Contract contract, Model model){
        contractService.save(contract);
        return "redirect:/contract";
    }
}
