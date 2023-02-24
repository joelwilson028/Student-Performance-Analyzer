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
 * Servlet implementation class UpdatestudentServlet
 */
@WebServlet("/UpdatestudentServlet")
public class UpdatestudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String upenroll = request.getParameter("enrollno");
		Companydao cd = new Companydao();
		Studentform us = cd.getStudent(upenroll);
		RequestDispatcher rd = request.getRequestDispatcher("Studentupdatedetail.jsp");
		request.setAttribute("studentup", us);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fullname = request.getParameter("ufn");// Values are coming from studentupdatedetail.jsp.
		String enrollno = request.getParameter("uenroll");// Values are coming from studentupdatedetail.jsp.
		String email = request.getParameter("uemail");// Values are coming from studentupdatedetail.jsp.
		String mobileno = request.getParameter("umobile");// Values are coming from studentupdatedetail.jsp.
		String branch = request.getParameter("ubranch");// Values are coming from studentupdatedetail.jsp.
		String sem = request.getParameter("usem");// Values are coming from studentupdatedetail.jsp.
		
		Studentform usf = new Studentform(fullname, enrollno, email, mobileno, branch, sem);
		Companydao cd = new Companydao();
		int i = cd.updateStudentDetails(usf);
		ArrayList<Studentform> list = cd.getAllStudentDetails();
		RequestDispatcher rd = null;
		if(i!=0)
		{
			rd = request.getRequestDispatcher("Studentdetails.jsp");
			request.setAttribute("status","Record Updated Successfully.");
			request.setAttribute("LIST",list);
			rd.forward(request, response);
		}
		else
		{
			rd = request.getRequestDispatcher("Studentdetails.jsp");
			request.setAttribute("status","Record Not Updated.");
			request.setAttribute("LIST",list);
			rd.forward(request, response);
		}
	}

}
