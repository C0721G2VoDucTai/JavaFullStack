package servlet;

import bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListCustomerServlet", urlPatterns = "")
public class ListCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List< Customer > customerList = new ArrayList();
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://dongthanhphat.vn//userfiles/images/Partner/anh-dai-dien-FB-200.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang","https://anhdep123.com/wp-content/uploads/2021/05/hinh-avatar-trang.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định","https://dongthanhphat.vn//userfiles/images/Partner/anh-dai-dien-FB-200.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-23", "Hà Tây","https://anhdep123.com/wp-content/uploads/2021/05/hinh-avatar-trang.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-24", "Hà Nội","https://anhdep123.com/wp-content/uploads/2021/05/hinh-avatar-trang.jpg"));
        request.setAttribute("customerListServlet",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

}
