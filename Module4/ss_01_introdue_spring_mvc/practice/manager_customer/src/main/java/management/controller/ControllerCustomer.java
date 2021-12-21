package management.controller;

import management.model.Customer;
import management.service.CustomerService;
import management.service.CustomerServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;
import java.util.List;

@Controller
public class ControllerCustomer {
//    private CustomerService customerService = CustomerServiceFactory.getInstance();
    @Autowired CustomerService customerService;
    @GetMapping("")
    public String showList(Model mode) {
        List< Customer > customers = customerService.findAll();
       mode.addAttribute("customers", customers);
        return "customers/list";
    }
}
//public class ControllerCustomer {
//    private CustomerService customerService = CustomerServiceFactory.getInstance();
//    @GetMapping("")
//    public String showList(HttpServletRequest request) {
//        List< Customer > customers = customerService.findAll();
//        request.setAttribute("customers", customers);
//        return "customers/list";
//    }
//}
