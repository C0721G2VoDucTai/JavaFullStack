package controller;

import bean.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/user", ""})
public class UserServlet extends HttpServlet {
    IUserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String notice = request.getParameter("notice");
        if (notice == null) {
            notice = "";
        }
        try {
            switch (notice) {
                case "create":
                    createUser(request, response);
                    break;
                case "edit":
                    editUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "sort":
                    sortByNameUser(request, response);
                    break;
                case "search":
                    searchByCountry(request, response);
                    break;
                default:
                    showListUser(request, response);
                    break;
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String notice = request.getParameter("notice");
        if (notice == null) {
            notice = "";
        }
        try {
            switch (notice) {
                case "create":
                    showFormCreate(request, response);
                    break;
                case "edit":
                    showUserEdit(request, response);
                    break;
                case "delete":
                    showDeleteUser(request, response);
                    break;
                default:
                    showListUser(request, response);
                    break;
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    public void showListUser(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List< User > userList = userService.selectAllUser();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    public void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    public void createUser(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        userService.insertUser(user);
        request.setAttribute("message", "New user was created");
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    public void showUserEdit(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUser(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    public void editUser(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        if (user == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else {
//            request.setAttribute("user", user);
            userService.updateUser(user);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
            request.setAttribute("message", "User information was updated");
        }
    }

    public void showDeleteUser(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUser(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("delete.jsp").forward(request, response);
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUser(id);
        if (user == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else {
            userService.deleteUser(id);
            response.sendRedirect("/user");
        }
    }

    public void sortByNameUser(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List< User > userList = userService.orderByName();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("sort.jsp").forward(request, response);
    }

    public void searchByCountry(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String countryName = request.getParameter("countryName");
        List< User > userList = userService.selectByCountry(countryName);
        if (userList == null) {
            request.getRequestDispatcher("error-404.jsp").forward(request,response);
        } else {
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }
    }
}