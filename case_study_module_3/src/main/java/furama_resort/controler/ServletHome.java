package furama_resort.controler;

import furama_resort.bean.employee.Employee;
import furama_resort.repository.IEmployeeRepository;
import furama_resort.repository.impl.EmployeeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static furama_resort.controler.EmployeeServlet.showListEmployee;

@WebServlet(name = "ServletHome", urlPatterns = {"/home", ""})
public class ServletHome extends HttpServlet {
    IEmployeeRepository employeeRepository = new EmployeeRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
