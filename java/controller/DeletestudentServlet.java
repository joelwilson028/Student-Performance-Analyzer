package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Studentform;
import mvc.Companydao;

/**
 * Servlet implementation class DeletestudentServlet
 */
@WebServlet("/DeletestudentServlet")
public class DeletestudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String denroll = request.getParameter("enrollno");
		Companydao cd = new Companydao();
		int i = cd.deleteStudentDetails(denroll);
		ArrayList<Studentform> list = cd.getAllStudentDetails();
		RequestDispatcher rd = null;
		if(i!=0)
		{
			rd = request.getRequestDispatcher("Studentdetails.jsp");
			request.setAttribute("status", "Record Deleted Successfully.");
			request.setAttribute("LIST", list);
			rd.forward(request, response);
		}
		else
		{
			rd = request.getRequestDispatcher("Studentdetails.jsp");
			request.setAttribute("status", "Record not Deleted.");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
