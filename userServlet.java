package test2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * james
 */

@WebServlet("/register")
public class userServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private userDao employeeDao;

    public void init() {
        employeeDao = new userDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int result = 1;

        user employee = new user();
        employee.setUsername(username);
        employee.setPassword(password);

        try {
            result = employeeDao.registerEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (result != 0) {
        	response.sendRedirect("userdetails.jsp");
        }
        else	{
        	response.sendRedirect("userdetails2.jsp");
        }
    }
}
