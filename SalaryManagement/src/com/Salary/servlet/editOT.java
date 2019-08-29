package com.Salary.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Salary.service.IOTServiceImp;
import com.Salary.service.OTServiceImp;

/**
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class editOT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editOT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int empId=Integer.parseInt(request.getParameter("empId"));
		String date =request.getParameter("date");
		
		IOTServiceImp otDb=new OTServiceImp();
		
		System.out.println(date+"/n"+empId);
		
		request.setAttribute("Update",otDb.getOtById(empId,date));
		RequestDispatcher rd=request.getRequestDispatcher("UpdateOT.jsp");
		rd.forward(request,response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
