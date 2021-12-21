package voductai.count_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import voductai.count_view.model.Counter;

@Controller
@SessionAttributes("counter")
public class CountController {
    @ModelAttribute("counter")
    public Counter setUpCounter(){
        return new Counter();
    }
    @GetMapping("/")
    public String get (@ModelAttribute("counter")Counter counter) {
        counter.increment();
        return "/index";

    }
}
