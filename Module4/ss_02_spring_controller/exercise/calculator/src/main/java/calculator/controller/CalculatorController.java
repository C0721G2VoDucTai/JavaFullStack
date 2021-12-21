package calculator.controller;

import calculator.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping(value = "/calculator")
    public String showForm(){
        return "calculator/form";
    }
    @PostMapping("calculator")
    public String getResult(@RequestParam double numberOne, double numberTwo, char calculation, Model model){
        Calculator calculator = new Calculator();
        String result = calculator.calculation(numberOne,numberTwo,calculation);
        model.addAttribute("result", result);
        return "calculator/form";
    }
}
