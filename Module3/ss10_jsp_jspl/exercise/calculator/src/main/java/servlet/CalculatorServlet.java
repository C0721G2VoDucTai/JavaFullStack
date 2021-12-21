package servlet;

import bean.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculator"})
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double first = Double.parseDouble(request.getParameter("First"));
        Double second = Double.parseDouble(request.getParameter("Second"));
        char operator = request.getParameter("Operator").charAt(0);
        String result;
        try {
            result = String.valueOf(Calculator.calculator(first, second, operator));
        } catch (ArithmeticException e) {
           result = "Can't divide by 0";
        }
        request.setAttribute("calculatorResult", result);
        request.getRequestDispatcher("result_calculator.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
