package furama_resort.controler;

import furama_resort.bean.customer.Customer;
import furama_resort.bean.customer.CustomerType;
import furama_resort.bean.employee.Division;
import furama_resort.bean.employee.EducationDegree;
import furama_resort.bean.employee.Employee;
import furama_resort.bean.employee.Position;
import furama_resort.repository.ICustomerRepository;
import furama_resort.repository.impl.CustomerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static furama_resort.util.ConnectionData.close;
import static furama_resort.util.ConnectionData.getConnection;
import static furama_resort.util.GetInformationSQL.*;
import static furama_resort.util.GetInformationSQL.selectDivision;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")

public class CustomerServlet extends HttpServlet {
    public static ICustomerRepository customerRepository = new CustomerRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String note = request.getParameter("note");
        if (note == null) {
            note = "";
        }
        try {
            switch (note) {
                case "create":
                    createNewCustomer(request, response);
                    break;
                case "edit":
                    editCustomer(request, response);
                    break;
                case "search":
                    searchCustomer(request, response);
                    break;
                default:
                    showListCustomer(request, response);
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
                    showFormAddCustomer(request, response);
                    break;
                case "edit":
                    showCustomerEdit(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
                default:
                    showListCustomer(request, response);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List< Customer > customerList = customerRepository.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer/list.jsp").forward(request, response);
    }

    public void showFormAddCustomer(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List< CustomerType > customerTypeList = selectCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }

    public void createNewCustomer(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        CustomerType customerType = null;
        for (CustomerType ct : selectCustomerType()) {
            if (ct.getId() == customerTypeId) {
                customerType = ct;
            }
        }
        Customer customer = new Customer(customerType, name, birthDay,gender, idCard, phone, email, address);

        customerRepository.insertCustomer(customer);
        request.setAttribute("message", "New customer was created");
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }

    public void showCustomerEdit(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List< CustomerType > customerTypeList = selectCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        Customer customer = customerRepository.selectCustomer(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
    }

    public void editCustomer(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        String idCard = request.getParameter("idCard");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        CustomerType customerType = new CustomerType();
        customerType.setId(customerTypeId);
//        CustomerType customerType = null;
//        for (CustomerType customerType1 : selectCustomerType()) {
//            if (customerType1.getId() == customerTypeId) {
//                customerType = customerType1;
//            }
//        }
        Customer customer = new Customer(id, customerType, name, birthDay,gender, idCard, phone, email, address);
        System.out.println(customer.toString());

        if (customer == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else {
            customerRepository.updateCustomer(customer);
            request.setAttribute("message", "Customer information was updated");
            request.getRequestDispatcher("customer/edit.jsp").forward(request, response);

        }
    }

//    public void showDeleteEmployee(HttpServletRequest request, HttpServletResponse response) throws
//            ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Employee employee = employeeRepository.selectEmployee(id);
//        request.setAttribute("employee", employee);
//        request.getRequestDispatcher("employee/delete.jsp").forward(request, response);
//    }

    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerRepository.selectCustomer(id);
        if (customer == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else {
            customerRepository.deleteCustomer(id);
            response.sendRedirect("/customer");
        }
    }
    public void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String customerTypeName = request.getParameter("customerTypeName");
        String address = request.getParameter("address");
        List< Customer > customerList = customerRepository.searchCustomer(customerName,customerTypeName,address);
        if (customerList.size() == 0) {
            request.getRequestDispatcher("error-404.jsp").forward(request, response);
        } else {
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("customer/list.jsp").forward(request, response);
        }
    }

}
