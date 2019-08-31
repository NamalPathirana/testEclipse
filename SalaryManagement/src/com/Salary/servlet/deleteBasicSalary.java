package com.Salary.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Salary.service.BasicSalaryServiceImp;
import com.Salary.service.IPromotionsService;
import com.Salary.service.PromotionsServiceImp;

/**
 * Servlet implementation class deleteBasicSalary
 */
@WebServlet("/deleteBasicSalary")
public class deleteBasicSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteBasicSalary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String position=request.getParameter("position");	
		
		
		System.out.println(position+" position // "+"  position DELETER");
		
		BasicSalaryServiceImp acc=new BasicSalaryServiceImp();
		
		int rowsBS=acc.deleteBS(position);
		
		
		HttpSession session=request.getSession();
		
		session.setAttribute("rowsBS",rowsBS);
		
		response.sendRedirect("BasicSalaryView.jsp");
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		
		
		
		
	}

}
