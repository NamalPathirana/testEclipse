package com.Salary.servlet;

import java.io.IOException;
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
 * Servlet implementation class addPromotions
 */
@WebServlet("/addPromotions")
public class addPromotions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPromotions() {
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
		
		Promotions prom=new Promotions();
		
		prom.setEmpId(Integer.parseInt(request.getParameter("empId")));
		prom.setDate((request.getParameter("date")));
		prom.setPromotion(Double.parseDouble(request.getParameter("promotion")));
		
		double tempprom=prom.getPromotion();
		
		
		if(tempprom<0 || tempprom>50000) {
			
			boolean promError=true;
			
			HttpSession session=request.getSession();
			
			session.setAttribute("promError",promError);
			
			response.sendRedirect("SalaryManagement.jsp");
			
			
		}
		else {
		
		
		IPromotionsService addprom=new PromotionsServiceImp(); 
		
		int rowsPro=addprom.addOt(prom);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("rowsPro",rowsPro);
		
		response.sendRedirect("SalaryManagement.jsp");
		}		
				
				
		
	}

}
