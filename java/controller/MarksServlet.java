package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Marksupload;
import mvc.Companydao;

/**
 * Servlet implementation class MarksServlet
 */
@WebServlet("/MarksServlet")
public class MarksServlet extends HttpServlet 
{
	
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fname = request.getParameter("fname");
		String enrollno = request.getParameter("enrollno");
		String subject = request.getParameter("sub");
		double marksob = Double.parseDouble(request.getParameter("marksob"));
		double totalmarks = Double.parseDouble(request.getParameter("totalmarks"));
		
		Marksupload mu = new Marksupload(fname, enrollno, subject, marksob, totalmarks);
		Companydao cd = new Companydao();
		
		int i=0 ,j=0;
		if(marksob > totalmarks)
		{
			j=1;
		}
		else
		{
			i = cd.marksUpload(mu);
		}
		
		RequestDispatcher rd = null;
		if(i!=0)
		{
			 
			 rd = request.getRequestDispatcher("Marks.jsp");
			 request.setAttribute("status", "Success");
			 rd.forward(request, response);
		}
		
		else
		{
			if(j==1)
			{
				rd = request.getRequestDispatcher("Marks.jsp");
				request.setAttribute("status", "Marksfail");
				rd.forward(request, response);
			}
			else
			{
				rd = request.getRequestDispatcher("Marks.jsp");
				request.setAttribute("status", "Fail");
				rd.forward(request, response);
			}	
		}
		
	}

}
