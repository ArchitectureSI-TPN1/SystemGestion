package mypackage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypackage.dao.LoginDao;
import mypackage.model.Login;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 String name = request.getParameter("login");
		 String pwd = request.getParameter("password");
		 System.out.println(pwd);
		 Login login = new Login(name, pwd);
		 
		 int result = LoginDao.login(login);
		 if(result > 0 ) {
			 response.sendRedirect("welcome.jsp"); 
		 }else {
			 response.sendRedirect("404.jsp");
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
