package furama_resort.controler;

import furama_resort.bean.employee.Division;
import furama_resort.bean.employee.EducationDegree;
import furama_resort.bean.employee.Employee;
import furama_resort.bean.employee.Position;
import furama_resort.bean.service.RentalType;
import furama_resort.bean.service.Service;
import furama_resort.bean.service.ServiceType;
import furama_resort.repository.IServiceRepository;
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
import static furama_resort.util.GetInformationSQL.selectDivision;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    static IServiceRepository serviceRepository = new ServiceRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String note = request.getParameter("note");
        if (note == null) {
            note = "";
        }
        try {
            switch (note) {
                case "create":
                    createNewService(request, response);
                    break;
                default:
                    showListService(request, response);
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
                    showFormCreateService(request, response);
                    break;
                default:
                    showListService(request, response);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void showListService(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List< Service > serviceList = serviceRepository.selectAllService();
        request.setAttribute("serviceList", serviceList);
        request.getRequestDispatcher("service/list.jsp").forward(request, response);
    }

    public void showFormCreateService(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List< ServiceType > serviceTypeList = GetInformationSQL.selectServiceType();
        request.setAttribute("serviceTypeList", serviceTypeList);
        List< RentalType > rentalTypeList = GetInformationSQL.selectRentalType();
        request.setAttribute("rentalTypeList", rentalTypeList);
        request.getRequestDispatcher("service/create.jsp").forward(request, response);
    }

    public void createNewService(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String name = request.getParameter("name");
        int area = Integer.valueOf(request.getParameter("area"));
        int cost = Integer.valueOf(request.getParameter("cost"));
        int numberOfPerson = Integer.valueOf(request.getParameter("numberOfPerson"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        int poolArea = Integer.valueOf(request.getParameter("poolArea"));
        int numberOfFloor = Integer.valueOf(request.getParameter("numberOfFloor"));
        int rentalTypeId = Integer.parseInt(request.getParameter("rentalTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        RentalType rentalType = new RentalType(rentalTypeId);
        ServiceType serviceType = new ServiceType(serviceTypeId);
        Service service = new Service(name, area, cost, numberOfPerson, rentalType,
                serviceType, standardRoom, description, poolArea, numberOfFloor);

        serviceRepository.insertService(service);
        request.setAttribute("message", "New service was created");
        request.getRequestDispatcher("service/create.jsp").forward(request, response);
    }
}
