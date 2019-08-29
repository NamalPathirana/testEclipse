package com.Salary.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Salary.model.Promotions;
import com.Salary.service.IPromotionsService;
import com.Salary.service.PromotionsServiceImp;

/**
 * Servlet implementation class editProm
 */
@WebServlet("/editProm")
public class editProm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editProm() {
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
		
		IPromotionsService allprom=new PromotionsServiceImp();
		
		List<Promotions> ls=allprom.getPromotionById(empId);
		
		System.out.println(empId+" Promotion update");
		
		request.setAttribute("Update",ls);
		RequestDispatcher rd=request.getRequestDispatcher("updatePromotion.jsp");
		rd.forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		
	}

}
