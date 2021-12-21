package furama_resort.controler;

import furama_resort.bean.contract.Contract;
import furama_resort.bean.customer.Customer;
import furama_resort.bean.employee.Division;
import furama_resort.bean.employee.EducationDegree;
import furama_resort.bean.employee.Employee;
import furama_resort.bean.employee.Position;
import furama_resort.bean.service.RentalType;
import furama_resort.bean.service.Service;
import furama_resort.bean.service.ServiceType;
import furama_resort.repository.IContractRepository;
import furama_resort.repository.ICustomerRepository;
import furama_resort.repository.IEmployeeRepository;
import furama_resort.repository.IServiceRepository;
import furama_resort.repository.impl.ContractRepository;
import furama_resort.repository.impl.CustomerRepository;
import furama_resort.repository.impl.EmployeeRepository;
import furama_resort.repository.impl.ServiceRepository;
import furama_resort.util.GetInformationSQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static furama_resort.util.GetInformationSQL.*;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    static IContractRepository contractRepository = new ContractRepository();
    static IEmployeeRepository employeeRepository = new EmployeeRepository();
    static ICustomerRepository customerRepository = new CustomerRepository();
    static IServiceRepository serviceRepository = new ServiceRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String note = request.getParameter("note");
        if (note == null) {
            note = "";
        }
        try {
            switch (note) {
                case "create":
                    createNewContract(request, response);
                    break;
                default:
                    showListContract(request, response);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String note = request.getParameter("note");
        if (note == null) {
            note = "";
        }
        try {
            switch (note) {
                case "create":
                    showFormCreateContract(request, response);
                    break;
                default:
                    showListContract(request, response);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void showListContract(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List< Contract > contractList = contractRepository.selectAllContract();
        request.setAttribute("contractList", contractList);
        request.getRequestDispatcher("contract/list.jsp").forward(request, response);
    }

    public void showFormCreateContract(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List< Employee > employeeList = employeeRepository.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        List< Customer > customerList = customerRepository.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        List< Service > serviceList = serviceRepository.selectAllService();
        request.setAttribute("serviceList", serviceList);
        request.getRequestDispatcher("contract/create.jsp").forward(request, response);
    }

    public void createNewContract(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String name = request.getParameter("name");
       String employeeId =request.getParameter("employeeId");
        int customerId = Integer.valueOf(request.getParameter("customerId"));
        int serviceId = Integer.valueOf(request.getParameter("serviceId"));
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        int deposit = Integer.valueOf(request.getParameter("deposit"));
        int totalMoney = Integer.valueOf(request.getParameter("totalMoney"));
        Employee employee = new Employee();
        employee.setId(employeeId);
        Service service = new Service();
        service.setId(serviceId);
        Customer customer = new Customer();
        customer.setId(customerId);
        Contract contract = new Contract(employee, customer, service, checkIn, checkOut,
                deposit, totalMoney);

        contractRepository.insertContract(contract);
        request.setAttribute("message", "New contract was created");
        request.getRequestDispatcher("contract/create.jsp").forward(request, response);
    }
}
