package com.Salary.servlet;

import java.io.IOException;

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
 * Servlet implementation class addot
 */
@WebServlet("/addot")
public class addot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		OT ot=new OT(Integer.parseInt(request.getParameter("empId")),request.getParameter("date"),Integer.parseInt(request.getParameter("hours")));
		
		IOTServiceImp imp=new OTServiceImp();
		
		int rows=imp.addOt(ot);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("rowsOT",rows);
		
		response.sendRedirect("SalaryManagement.jsp");
		
		
		
	}

}
