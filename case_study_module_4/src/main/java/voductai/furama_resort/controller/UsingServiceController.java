package voductai.furama_resort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import voductai.furama_resort.dto.CustomerUseServiceDTO;
import voductai.furama_resort.service.contract.IAttachServiceService;
import voductai.furama_resort.service.contract.IContractDetailService;
import voductai.furama_resort.service.contract.IContractService;
import voductai.furama_resort.service.customer.ICustomerService;

import java.util.List;

@Controller
public class UsingServiceController {
    @Autowired
   private ICustomerService customerService;
//    @Autowired
//    IContractService contractService;
//    @Autowired
//    IContractDetailService contractDetailService;
//    @Autowired
//    IAttachServiceService attachServiceService;
    @GetMapping("list-customer-use-service")
    public String showList(Pageable pageable, Model model){
        Page<CustomerUseServiceDTO> customerUseServiceDTOPage = customerService.listCustomerUsingService(pageable);
        model.addAttribute("customerUseServiceDTOPage", customerUseServiceDTOPage);
        List<CustomerUseServiceDTO> serviceDTOS = customerUseServiceDTOPage.getContent();
        return "customer/list-use";
    }
}
