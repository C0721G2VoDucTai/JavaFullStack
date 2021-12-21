package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet",  urlPatterns = {"/land"})
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String note = request.getParameter("note");
        if (note == null) {
            note = "";
        }
        try {
            switch (note) {
                case "create":
                    createNewLand(request, response);
                    break;
//                case "edit":
//                    editEmployee(request, response);
//                    break;
                case "search":
                    searchLand(request, response);
                    break;
                default:
                    showListLand(request, response);
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
                    showFormAddLand(request, response);
                    break;
//                case "edit":
//                    showEmployeeEdit(request, response);
//                    break;
                case "delete":
                    deleteLand(request, response);
                    break;
                default:
                    showListLand(request, response);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    public static void showListLand(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        List< Land > landList = landRepo.selectAllLand();
        request.setAttribute("landList", landList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    public void showFormAddLand(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List< LandStatus > landStatusList = GetData.selectLandStatus();
        List< LandType > landTypeList = GetData.selectLandType();
        request.setAttribute("landStatusList", landStatusList);
        request.setAttribute("landTypeList", landTypeList);
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    public void createNewLand(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        Boolean flag = false;
        String idError = "";
//        String phoneError = "";
//        String emailError = "";
//        String birthDayError = "";
//        String idCardError = "";
//        String salaryError = "";
        String id = request.getParameter("id");
        int landStatusId = Integer.valueOf(request.getParameter("landStatusId"));
        LandStatus landStatus = new LandStatus();
        landStatus.setId(landStatusId);
        int area = Integer.valueOf(request.getParameter("area"));
        int floor = Integer.valueOf(request.getParameter("floor"));
        int price = Integer.valueOf(request.getParameter("price"));
        int landTypeId = Integer.valueOf(request.getParameter("landTypeId"));
        LandType landType = new LandType();
        landType.setId(landTypeId);
        String checkin = request.getParameter("checkin");
        String checkout = request.getParameter("checkout");
        if(Validate.checkRegex(id,Validate.ID_LAND)) {
            flag = true;
            idError += "Wrong format, ex: NV-XXXX";
            List <Land> landList = landRepo.selectAllLand();
            for(Land list : landList) {
                if(list.getId().equals(id)) {
                    idError += "id is duplicate, please enter id again";
                }
            }
        }

//        if(Validate.checkRegex(birthDay,Validate.DATE_REGEX)) {
//            flag = true;
//            birthDayError = "Wrong format, ex: YYYY-MM-DD";
//        }
//        if(Validate.checkRegex(idCard,Validate.ID_CARD_REGEX)){
//            flag=true;
//            idCardError ="Wrong format, ex: XXXXXXXXX or XXXXXXXXXXXX";
//        }
//        if(salary<=0) {
//            flag = true;
//            salaryError = "please enter a positive number";
//        }
//        if(Validate.checkRegex(phone,Validate.PHONE_REGEX)) {
//            flag = true;
//            phoneError = "Wrong format, ex: 090xxxxxxx/091xxxxxxx/84)+90xxxxxxx/(84)+91xxxxxxx";
//        }
//        if(Validate.checkRegex(email,Validate.EMAIL_REGEX)) {
//            flag = true;
//            emailError = "Wrong format, ex: hainam123@gmail.com";
//        }
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
        Land land = new Land(id, landStatus, area, floor, landType, price, checkin, checkout);
        if (flag) {
            request.setAttribute("idError", idError);
//            request.setAttribute("phoneError", phoneError);
//            request.setAttribute("emailError", emailError);
//            request.setAttribute("birthDayError", birthDayError);
//            request.setAttribute("idCardError", idCardError);
//            request.setAttribute("salaryError", salaryError);
//            request.setAttribute("employee", employee);
            showFormAddLand(request, response);
        }
        landRepo.insertLand(land);
        response.sendRedirect("/land");
    }

    public void deleteLand(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String id = request.getParameter("id");
        landRepo.deleteLand(id);
        response.sendRedirect("/land");
    }

    public void searchLand(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String landTypeName = request.getParameter("landTypeName");
        String floor = request.getParameter("floor");
        String price = request.getParameter("price");
        List< Land > landList;
        if ((landTypeName == "") | (floor == "") | (price == "")) {
            landList = landRepo.searchLandField(landTypeName, price, floor);
        } else {
            landList = landRepo.searchLand(landTypeName, Integer.parseInt(price), Integer.parseInt(floor));
        }
        request.setAttribute("landList", landList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
