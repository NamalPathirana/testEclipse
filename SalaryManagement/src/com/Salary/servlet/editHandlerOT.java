package com.Salary.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Salary.model.OT;
import com.Salary.service.IOTServiceImp;
import com.Salary.service.OTServiceImp;

/**
 * Servlet implementation class editHandler
 */
@WebServlet("/editHandler")
public class editHandlerOT extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editHandlerOT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: srr").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
//		HttpSession session=request.getSession();
		
		OT ot=new OT(Integer.parseInt(request.getParameter("empId")),request.getParameter("date"),Integer.parseInt(request.getParameter("hours")));
		
		IOTServiceImp ots=new OTServiceImp();
		
		int rows=ots.edit(ot.getEmpID(),ot.getDate(),ot.getHours());
		
		request.setAttribute("rows",rows);
		RequestDispatcher rd =request.getRequestDispatcher("OTView.jsp");
	 	rd.forward(request, response);
		
		
		
	}

}
