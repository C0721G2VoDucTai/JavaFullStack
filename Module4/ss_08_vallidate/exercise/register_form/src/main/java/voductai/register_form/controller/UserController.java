package voductai.register_form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;
import voductai.register_form.model.User;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/validate")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "/form";
    }

    @PostMapping("create")
    public String showResult(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult,
                                     Model model) {
        new User().validate(user,bindingResult);
        if (bindingResult.hasErrors()) {
            return "/form";
        }
        return "/result";
    }
}
