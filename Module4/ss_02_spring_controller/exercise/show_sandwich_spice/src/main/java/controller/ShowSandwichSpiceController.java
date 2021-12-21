package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowSandwichSpiceController {
    @GetMapping("/form")
    public String showForm() {
        return "form";
    }
    @PostMapping("/form")
    public String save(@RequestParam String[] condiment, Model model){
        model.addAttribute("condiment", condiment);
        return "form";
    }

}
