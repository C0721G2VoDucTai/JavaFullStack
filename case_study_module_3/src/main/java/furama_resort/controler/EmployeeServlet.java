package furama_resort.controler;

import furama_resort.bean.employee.Division;
import furama_resort.bean.employee.EducationDegree;
import furama_resort.bean.employee.Employee;
import furama_resort.bean.employee.Position;
import furama_resort.repository.IEmployeeRepository;
import furama_resort.repository.impl.EmployeeRepository;
import furama_resort.util.GetInformationSQL;
import furama_resort.util.Validate;
import javafx.geometry.Pos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static furama_resort.util.GetInformationSQL.*;
import static furama_resort.util.Validate.ID_CARD_REGEX;
import static furama_resort.util.Validate.ID_EMPLOYEE;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
    static IEmployeeRepository employeeRepository = new EmployeeRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String note = request.getParameter("note");
        if (note == null) {
            note = "";
        }
        try {
            switch (note) {
                case "create":
                    createNewEmployee(request, response);
                    break;
                case "edit":
                    editEmployee(request, response);
                    break;
                case "search":
                    searchEmployee(request, response);
                    break;
                default:
                    showListEmployee(request, response);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String note = request.getParameter("note");
        if (note == null) {
            note = "";
        }
        try {
            switch (note) {
                case "create":
                    showFormAddEmployee(request, response);
                    break;
                case "edit":
                    showEmployeeEdit(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                default:
                    showListEmployee(request, response);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
//        List< User > userList = employeeRepository.selectAllEmployee();
        List< Employee > employeeList = employeeRepository.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/list.jsp").forward(request, response);
    }

    public void showFormAddEmployee(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List< Position > positionList = selectPosition();
        request.setAttribute("positionList", positionList);
        List< EducationDegree > degreeList = selectEducationDegree();
        request.setAttribute("degreeList", degreeList);
        List< Division > divisionList = selectDivision();
        request.setAttribute("divisionList", divisionList);
        request.getRequestDispatcher("employee/create.jsp").forward(request, response);
    }

    public void createNewEmployee(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        Boolean flag = false;
        String idError = "";
        String phoneError = "";
        String emailError = "";
        String birthDayError = "";
        String idCardError = "";
        String salaryError = "";
        String id = request.getParameter("id");
        if (Validate.checkRegex(id, Validate.ID_EMPLOYEE)) {
            flag = true;
            idError = "Wrong format, ex: NV-XXXX";
        }
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        if (Validate.checkRegex(birthDay, Validate.DATE_REGEX)) {
            flag = true;
            birthDayError = "Wrong format, ex: YYYY-MM-DD";
        }
        String idCard = request.getParameter("idCard");
        if (Validate.checkRegex(idCard, Validate.ID_CARD_REGEX)) {
            flag = true;
            idCardError = "Wrong format, ex: XXXXXXXXX or XXXXXXXXXXXX";
        }
        Double salary = Double.valueOf(request.getParameter("salary"));
        if (salary <= 0) {
            flag = true;
            salaryError = "please enter a positive number";
        }

        String phone = request.getParameter("phone");

        if (Validate.checkRegex(phone, Validate.PHONE_REGEX)) {
            flag = true;
            phoneError = "Wrong format, ex: 090xxxxxxx/091xxxxxxx/84)+90xxxxxxx/(84)+91xxxxxxx";
        }
        String email = request.getParameter("email");

        if (Validate.checkRegex(email, Validate.EMAIL_REGEX)) {
            flag = true;
            emailError = "Wrong format, ex: hainam123@gmail.com";
        }
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int degreeId = Integer.parseInt(request.getParameter("degreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Position position = new Position(positionId);
        EducationDegree educationDegree = new EducationDegree(degreeId);
        Division division = new Division(divisionId);
//        for (Position positions : selectPosition()) {
//            if (positions.getId() == positionId) {
//                position = positions;
//            }
//        }
//        for (EducationDegree educationDegrees : selectEducationDegree()) {
//            if (educationDegrees.getId() == degreeId) {
//                educationDegree = educationDegrees;
//            }
//        }
//        for (Division division1 : selectDivision()) {
//            if (division1.getId() == divisionId) {
//                division = division1;
//            }
//        }
        Employee employee = new Employee(id, name, birthDay, idCard, salary, phone, email, address, position,
                educationDegree, division);
        if (flag) {
            request.setAttribute("phoneError", phoneError);
            request.setAttribute("emailError", emailError);
            request.setAttribute("idError", idError);
            request.setAttribute("birthDayError", birthDayError);
            request.setAttribute("idCardError", idCardError);
            request.setAttribute("salaryError", salaryError);
            request.setAttribute("employee", employee);
            showFormAddEmployee(request, response);

        } else {
            employeeRepository.insertEmployee(employee);
            request.setAttribute("message", "New employee was created");
            request.getRequestDispatcher("employee/create.jsp").forward(request, response);
        }
    }

    public void showEmployeeEdit(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String id = request.getParameter("id");
        List< Position > positionList = GetInformationSQL.selectPosition();
        request.setAttribute("positionList", positionList);
        List< EducationDegree > degreeList = GetInformationSQL.selectEducationDegree();
        request.setAttribute("degreeList", degreeList);
        List< Division > divisionList = GetInformationSQL.selectDivision();
        request.setAttribute("divisionList", divisionList);
        Employee employee = employeeRepository.selectEmployee(id);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("employee/edit.jsp").forward(request, response);
    }
    public void editEmployee(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        String idCard = request.getParameter("idCard");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int degreeId = Integer.parseInt(request.getParameter("degreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Position position = new Position(positionId);
        EducationDegree educationDegree = new EducationDegree(degreeId);
        Division division = new Division (divisionId);
//        for (Position positions : selectPosition()) {
//            if (positions.getId() == positionId) {
//                position = positions;
//            }
//        }
//        for (EducationDegree educationDegrees : selectEducationDegree()) {
//            if (educationDegrees.getId() == degreeId) {
//                educationDegree = educationDegrees;
//            }
//        }
//        for (Division division1 : selectDivision()) {
//            if (division1.getId() == divisionId) {
//                division = division1;
//            }
//        }
        Employee employee = new Employee(id, name, birthDay, idCard, salary, phone, email, address, position,
                educationDegree, division);
        System.out.println(employee.toString());

        if (employee == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else {
            employeeRepository.updateEmployee(employee);
            request.setAttribute("message", "Employee information was updated");
            request.getRequestDispatcher("employee/edit.jsp").forward(request, response);

        }
    }

    public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String id = request.getParameter("id");
        Employee employee = employeeRepository.selectEmployee(id);
        if (employee == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else {
            employeeRepository.deleteEmployee(id);
            response.sendRedirect("/home");
        }
    }

    public void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String employeeName = request.getParameter("employeeName");
        List< Employee > employeeList = employeeRepository.searchEmployee(employeeName);
        if (employeeList == null) {
            request.getRequestDispatcher("error-404.jsp").forward(request, response);
        } else {
            request.setAttribute("employeeList", employeeList);
            request.getRequestDispatcher("employee/list.jsp").forward(request, response);
        }
    }
}
