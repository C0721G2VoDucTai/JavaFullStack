package controller;

import bean.Book;
import bean.Student;
import bean.Ticket;
import repository.ILandRepo;
import repository.LandRepo;
import utill.GetData;
import utill.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LandServlet", urlPatterns = {"/book"})
public class LandServlet extends HttpServlet {
    static ILandRepo landRepo = new LandRepo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String note = request.getParameter("note");
        if (note == null) {
            note = "";
        }
        try {
            switch (note) {
//                case "create":
//                    createNew(request, response);
//                    break;
                case "edit":
                    edit(request, response);
                    break;
//                case "search":
//                    search(request, response);
//                    break;
                default:
                    showListBook(request, response);
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
                    showList(request, response);
                    break;
                case "edit":
                    showEdit(request, response);
                    break;
//                case "delete":
//                    delete(request, response);
//                    break;
                default:
                    showListBook(request, response);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void showListBook(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        List< Book > bookList = GetData.selectBook();
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
    public static void showList(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List< Ticket > ticketList = landRepo.selectAll();
        request.setAttribute("ticketList", ticketList);
        request.getRequestDispatcher("list_all.jsp").forward(request, response);
    }

    //    public void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws
//            ServletException, IOException {
//        List< Ticket > ticketList = GetData.selectLandStatus();
//        List< Student > studentList = GetData.selectLandType();
//        request.setAttribute("landStatusList", ticketList);
//        request.setAttribute("landTypeList", studentList);
//        request.getRequestDispatcher("create.jsp").forward(request, response);
//    }
//
//    public void createNew(HttpServletRequest request, HttpServletResponse response) throws
//            ServletException, IOException {
//        Boolean flag = false;
//        String idError = "";
//        String areaError = "";
//        String priceError = "";
//        String floorError = "";
//        String dateError = "";
//        String emptyError = "";
////        String idCardError = "";
////        String salaryError = "";
//        String id = request.getParameter("id");
//        String landStatusId = request.getParameter("landStatusId");
//        Ticket ticket = new Ticket();
//        String area = request.getParameter("area");
//        String floor = request.getParameter("floor");
//        String price = request.getParameter("price");
//        String landTypeId = request.getParameter("landTypeId");
//        Student student = new Student();
//        String checkin = request.getParameter("checkin");
//        String checkout = request.getParameter("checkout");
//        if (Validate.checkRegex(id, Validate.ID_LAND)) {
//            flag = true;
//            idError += "Wrong format, ex: NV-XXXX";
//            List< Book > bookList = landRepo.selectAll();
//            for (Book list : bookList) {
//                if (list.getId().equals(id)) {
//                    idError += "id is duplicate, please enter id again";
//                }
//            }
//        }
//        if (Validate.checkRegex(String.valueOf(area), Validate.NUMBER_REGEX) | area == "") {
//            flag = true;
//            areaError = "please enter a positive number";
//            area = String.valueOf(0);
//        }
//        if (Validate.checkRegex(String.valueOf(floor), Validate.NUMBER_REGEX) | floor == "") {
//            flag = true;
//            floorError = "please enter a positive number";
//            floor = String.valueOf(0);
//        }
//        if (Validate.checkRegex(String.valueOf(price), Validate.NUMBER_REGEX) | price == "") {
//            flag = true;
//            priceError = "please enter a positive number";
//            price = String.valueOf(0);
//        }
//        if (Validate.checkRegex(String.valueOf(checkin), Validate.DATE_REGEX)) {
//            flag = true;
//            dateError = "please enter a date like form";
//        }
//        if (Validate.checkRegex(String.valueOf(checkout), Validate.DATE_REGEX)) {
//            flag = true;
//            dateError = "please enter a date like form";
//        }
//        //        if(Validate.checkRegex(idCard,Validate.ID_CARD_REGEX)){
////            flag=true;
////            idCardError ="Wrong format, ex: XXXXXXXXX or XXXXXXXXXXXX";
////        }
////        if(Validate.checkRegex(phone,Validate.PHONE_REGEX)) {
////            flag = true;
////            phoneError = "Wrong format, ex: 090xxxxxxx/091xxxxxxx/84)+90xxxxxxx/(84)+91xxxxxxx";
////        }
////        if(Validate.checkRegex(email,Validate.EMAIL_REGEX)) {
////            flag = true;
////            emailError = "Wrong format, ex: hainam123@gmail.com";
////        }
////        if (landStatusId == "") {
////            flag = true;
////            floorError = "please enter a positive number";
////            landStatusId = String.valueOf(0);
////        }
////        if (landTypeId == "") {
////            flag = true;
////            floorError = "please enter a positive number";
////            landTypeId = String.valueOf(0);
////        }
//        student.setId(Integer.parseInt(landTypeId));
//        ticket.setId(Integer.valueOf(landStatusId));
//        Book book = new Book(id, ticket, Integer.valueOf(area), Integer.valueOf(floor), student,
//                Integer.valueOf(price), checkin, checkout);
//        if (flag) {
//            request.setAttribute("idError", idError);
//            request.setAttribute("areaError", areaError);
//            request.setAttribute("floorError", floorError);
//            request.setAttribute("priceError", priceError);
//            request.setAttribute("dateError", dateError);
//            request.setAttribute("emptyError", emptyError);
////            request.setAttribute("idCardError", idCardError);
////            request.setAttribute("salaryError", salaryError);
//            request.setAttribute("land", book);
//            showFormAdd(request, response);
//        } else {
//            landRepo.insert(book);
//            response.sendRedirect("/land");
//        }
//    }
//
//    public void delete(HttpServletRequest request, HttpServletResponse response) throws
//            ServletException, IOException {
//        String id = request.getParameter("id");
//        landRepo.delete(id);
//        response.sendRedirect("/land");
//    }
//
//    public void search(HttpServletRequest request, HttpServletResponse response) throws
//            ServletException, IOException {
//        String landTypeName = request.getParameter("landTypeName");
//        String floor = request.getParameter("floor");
//        String price = request.getParameter("price");
//        List< Book > bookList;
//        if ((landTypeName == "") | (floor == "") | (price == "")) {
//            bookList = landRepo.searchOne(landTypeName, price, floor);
//        } else {
//            bookList = landRepo.searchThreeField(landTypeName, Integer.parseInt(price), Integer.parseInt(floor));
//        }
//        request.setAttribute("landList", bookList);
//        request.getRequestDispatcher("list.jsp").forward(request, response);
//    }
    public void showEdit(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String id = request.getParameter("id");
        List< Book > bookList = GetData.selectBook();
        request.setAttribute("bookList", bookList);
        List< Student > studentList = GetData.selectStudent();
        request.setAttribute("studentList", studentList);
        Ticket ticket = landRepo.selectId(id);
        request.setAttribute("ticket", ticket);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String id = request.getParameter("id");
//        String landStatusId = request.getParameter("landStatusId");
//        String landTypeId = request.getParameter("landTypeId");
//        String area = request.getParameter("area");
//        String floor = request.getParameter("floor");
//        String price = request.getParameter("price");
//        String checkin = request.getParameter("checkin");
//        String checkout = request.getParameter("checkout");
//        Ticket ticket = new Ticket();
//        Student student = new Student();
//        ticket.setId(Integer.parseInt(landStatusId));
//        student.setId(Integer.parseInt(landTypeId));
//        Book book = new Book(id, ticket, Integer.parseInt(area),Integer.parseInt(floor) ,
//                student,Integer.parseInt(price) , checkin, checkout);
//        System.out.println(book.toString());
//
//        if (book == null) {
//            request.getRequestDispatcher("error-404.jsp");
//        } else {
        landRepo.update(id);
        response.sendRedirect("/land");
    }
}





