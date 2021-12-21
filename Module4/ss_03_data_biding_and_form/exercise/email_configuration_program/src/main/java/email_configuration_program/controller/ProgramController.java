package email_configuration_program.controller;

import email_configuration_program.model.ConfigEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProgramController {
    @GetMapping("/showForm")
    public String showForm(Model model) {
        String[] languages = {"English", "Vietnamese", "Japanese", "Chinese"};
        Integer[] pageSizes = {5, 10, 15, 25, 50, 100};
        model.addAttribute("languages",languages);
        model.addAttribute("pageSizes",pageSizes);
        model.addAttribute("configEmail",new ConfigEmail());
        return "show/form";
    }

    @PostMapping("/form")
    public ModelAndView showConfig(@ModelAttribute("configEmail") ConfigEmail configEmail) {
        ModelAndView modelAndView = new ModelAndView("show/info", "configEmail", configEmail);
        return modelAndView;
    }
}
