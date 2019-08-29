package com.Salary.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Salary.service.IOTServiceImp;
import com.Salary.service.IPromotionsService;
import com.Salary.service.OTServiceImp;
import com.Salary.service.PromotionsServiceImp;

/**
 * Servlet implementation class deleteProm
 */
@WebServlet("/deleteProm")
public class deleteProm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteProm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		int empId=Integer.parseInt(request.getParameter("empId"));	
		
		
		System.out.println(empId+" empId // "+"  PROMOTION DELETER");
		
		IPromotionsService acc=new PromotionsServiceImp();
		
		int rows=acc.delete(empId);
		
		
		HttpSession session=request.getSession();
		
		session.setAttribute("rowsEditProm",rows);
		
		response.sendRedirect("PromotionsView.jsp");
		
	
	
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
	
		
		
		
		
		
	}

}
