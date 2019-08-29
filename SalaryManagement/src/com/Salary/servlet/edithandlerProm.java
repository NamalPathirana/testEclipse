package com.Salary.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Salary.model.Promotions;
import com.Salary.service.IPromotionsService;
import com.Salary.service.PromotionsServiceImp;

/**
 * Servlet implementation class edithandlerProm
 */
@WebServlet("/edithandlerProm")
public class edithandlerProm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edithandlerProm() {
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
		
		Promotions prom=new Promotions();
		
//		OT(Integer.parseInt(request.getParameter("empId")),request.getParameter("date"),Integer.parseInt(request.getParameter("hours")));
		
		prom.setEmpId(Integer.parseInt(request.getParameter("empId")));
		prom.setDate(request.getParameter("date"));
		prom.setPromotion(Double.parseDouble(request.getParameter("promotion")));
		
		double promotion=prom.getPromotion();
		
		if(promotion<0 || promotion>50000) {
			
			HttpSession session=request.getSession();
			
			session.setAttribute("rowsProm",promotion);
			response.sendRedirect("updatePromotion.jsp");;
			
		}
		
		
		IPromotionsService service=new PromotionsServiceImp();
		
		int rows=service.edit(prom.getEmpId(),prom.getDate(),prom.getPromotion());
		
		request.setAttribute("rowsEditProm",rows);
		RequestDispatcher rd =request.getRequestDispatcher("PromotionsView.jsp");
	 	rd.forward(request, response);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
