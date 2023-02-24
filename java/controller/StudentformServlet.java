package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Studentform;
import dto.Users;
import mvc.Companydao;

/**
 * Servlet implementation class StudentformServlet
 */
@WebServlet("/StudentformServlet")
public class StudentformServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sname = request.getParameter("sname");// Values are coming from signup.jsp.
		String senroll = request.getParameter("senrollno");// Values are coming from signup.jsp.
		String semail = request.getParameter("semail");// Values are coming from signup.jsp.
		String smobile = request.getParameter("smobile");// Values are coming from signup.jsp.
		String sbranch = request.getParameter("sbranch");
		String ssem = request.getParameter("ssem");
		
		Studentform sf = new Studentform(sname, senroll, semail, smobile, sbranch, ssem);
		Companydao cd = new Companydao();
		int i=0;
		int j= cd.checkStudentDetail(senroll,semail);
		RequestDispatcher rd = null;
		//i = cd.studentUpload(sf);
		
		/*if(i!=0)
		{
					rd = request.getRequestDispatcher("Studentform.jsp");
					request.setAttribute("status", "Success");
					rd.forward(request, response);
		}
		else 
		{
					rd = request.getRequestDispatcher("Studentform.jsp");
					request.setAttribute("status", "Fail");
					rd.forward(request, response);
		}*/
		
		if(j==0)
		{
			 i = cd.studentUpload(sf);
			 rd = request.getRequestDispatcher("Studentform.jsp");
			 request.setAttribute("status", "Success");
			 rd.forward(request, response);
		}
		
		else
		{
				if(j==1)
				{
					rd = request.getRequestDispatcher("Studentform.jsp");
					request.setAttribute("status", "FailureEmail");
					rd.forward(request, response);
				}
				else if(j==2)
				{
					rd = request.getRequestDispatcher("Studentform.jsp");
					request.setAttribute("status", "FailureEnroll");
					rd.forward(request, response);
				}
		}
		
		
	}

}
