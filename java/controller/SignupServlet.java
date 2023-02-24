package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Users;
import mvc.Companydao;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");// Values are coming from signup.jsp.
		String uemail = request.getParameter("email");// Values are coming from signup.jsp.
		String un = request.getParameter("uname");// Values are coming from signup.jsp.
		String pwd = request.getParameter("pass");// Values are coming from signup.jsp.
		
		Users u = new Users(name, uemail, un, pwd);
		Companydao cd = new Companydao();
		int i=0;
		int j= cd.checksignup(uemail,un);
		RequestDispatcher rd = null;
		if(j==0)
		{
			 i = cd.signupUser(u);
			 rd = request.getRequestDispatcher("registration1.jsp");
			 request.setAttribute("status", "Success");
			 rd.forward(request, response);
		}
		
		else
		{
				if(j==1)
				{
					rd = request.getRequestDispatcher("registration1.jsp");
					request.setAttribute("status", "FailureEmail");
					rd.forward(request, response);
				}
				else if(j==2)
				{
					rd = request.getRequestDispatcher("registration1.jsp");
					request.setAttribute("status", "FailureUsername");
					rd.forward(request, response);
				}
		}
		
		
	}

}
