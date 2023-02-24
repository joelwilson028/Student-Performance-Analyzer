package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.Companydao;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user = request.getParameter("uname");
		String pass = request.getParameter("pass");
		Companydao cd = new Companydao();
		int i = cd.checklogin(user, pass);
		RequestDispatcher rd = null;
		if(i!=0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user); // it defined that particular user session is going on.
			ServletContext servletcontext = getServletContext(); //Servlet Context is used to set attribute in one servlet and get in another servlet.
			servletcontext.setAttribute("username", user);
			rd = request.getRequestDispatcher("Loginindex.jsp");
			request.setAttribute("status", "Success");
			rd.forward(request, response);
		}
		else
		{
			rd = request.getRequestDispatcher("login1.jsp");
			request.setAttribute("status", "Fail");
			rd.forward(request, response);
		}
		
	}

}
