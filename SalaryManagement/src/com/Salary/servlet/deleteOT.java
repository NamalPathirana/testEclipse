package com.Salary.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Salary.service.IOTServiceImp;
import com.Salary.service.OTServiceImp;

/**
 * Servlet implementation class deleteOT
 */
@WebServlet("/delete")
public class deleteOT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteOT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		int empId=Integer.parseInt(request.getParameter("empId"));	
		String date=request.getParameter("date");
		
		System.out.println(empId+" date : "+date+"OT delete");
		
		IOTServiceImp acc=new OTServiceImp();
		
		int rows=acc.delete(empId, date);
		
		
		HttpSession session=request.getSession();
		
		session.setAttribute("rowsOT",rows);
		
		response.sendRedirect("OTView.jsp");
		
	
		
		
		
		}
		catch(Exception e) 
		{
		
			e.printStackTrace();
			
		}
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		
		
	}
	
	
	
	
	

}
