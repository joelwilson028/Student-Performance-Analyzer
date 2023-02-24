package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.Companydao;
import dto.Studentform;

/**
 * Servlet implementation class StudentdetailsServlet
 */
@WebServlet("/StudentdetailsServlet")
public class StudentdetailsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Companydao cd = new Companydao();
		ArrayList<Studentform> list = cd.getAllStudentDetails();
		RequestDispatcher rd = request.getRequestDispatcher("Studentdetails.jsp");
		request.setAttribute("LIST", list);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
