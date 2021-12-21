import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SumServlet", urlPatterns = "/sum_servlet")
public class SumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double a = Double.parseDouble(request.getParameter("numberOne"));
        double b = Double.parseDouble(request.getParameter("numberTwo"));
        double result = a + b;
        request.setAttribute("resultFromServlet", result);
        request.getRequestDispatcher("result_final.jsp").forward(request, response);
    }
}
