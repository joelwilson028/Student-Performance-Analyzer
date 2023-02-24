package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Marksupload;
import mvc.Companydao;

/**
 * Servlet implementation class AnalyzeServlet
 */
@WebServlet("/AnalyzeServlet")
public class AnalyzeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Companydao cd = new Companydao();
		ArrayList<Marksupload> list = cd.studentAnalysis();
		RequestDispatcher rd = request.getRequestDispatcher("Markdetails.jsp");
		request.setAttribute("LIST", list);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
