package com.Salary.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Salary.model.BasicSalary;
import com.Salary.model.Promotions;
import com.Salary.service.BasicSalaryServiceImp;
import com.Salary.service.IBasicSalaryService;
import com.Salary.service.IPromotionsService;
import com.Salary.service.PromotionsServiceImp;

/**
 * Servlet implementation class editBasicSalary
 */
@WebServlet("/editBasicSalary")
public class editBasicSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBasicSalary() {
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
		

		try {
		
		BasicSalary prom=new BasicSalary();
		
//		OT(Integer.parseInt(request.getParameter("empId")),request.getParameter("date"),Integer.parseInt(request.getParameter("hours")));
		
		prom.setPostion(request.getParameter("position"));
		prom.setDate(request.getParameter("date"));
		prom.setBasicsalary(Double.parseDouble(request.getParameter("basicSalary")));
		
		double promotion=prom.getBasicsalary();
		
		if(promotion<0 || promotion>50000) {
			
			HttpSession session=request.getSession();
			
			session.setAttribute("rowsBS",promotion);
			response.sendRedirect("updatePromotion.jsp");;
			
		}
		
		
		BasicSalaryServiceImp service=new BasicSalaryServiceImp();
		
		int rows=service.edit(prom.getPostion(), prom.getDate(), prom.getBasicsalary());
		
		request.setAttribute("rowsEditBS",rows);
		RequestDispatcher rd =request.getRequestDispatcher("BasicSalaryView.jsp");
	 	rd.forward(request, response);
		}
		catch(Exception e)
		{
			
			e.getMessage();
		}
		
		
		
		
	}

		
		
		
	}


