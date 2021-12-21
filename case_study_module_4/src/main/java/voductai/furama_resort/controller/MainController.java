package voductai.furama_resort.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping("/home")
    public String home(Model model){
        return "home";
    }
    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }
    @GetMapping("/logout")
    public String logoutPage(Model model) {
        return "/home";
    }
//    public String userInfo(Model model, Principal principal) {
//        model.addAttribute("principal", principal);
//
//        // Sau khi user login thanh cong se co principal
//        String userName = principal.getName();
//
//        System.out.println("User Name: " + userName);
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "userInfoPage";
//    }

    @GetMapping()
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";

    }
}
