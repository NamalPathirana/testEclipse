package com.Salary.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.Salary.model.BasicSalary;
import com.Salary.model.Promotions;
import com.Salary.utility.DBconnection;

public class BasicSalaryServiceImp {
	
	
	public int addOt(BasicSalary bs) {
		
		String addOtQuery="insert into basicSalary (posistion,date,basicSalary) values(?,?,?)";
		int rows=0;
		
		Connection DB;
		try {
			
			DB = DBconnection.getconnection();
			PreparedStatement ps=DB.prepareStatement(addOtQuery);
			
			ps.setString(1,bs.getPostion());
			ps.setString(2,bs.getDate());
			ps.setDouble(3,bs.getBasicsalary());
			
			rows=ps.executeUpdate();
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;	
		
	}
	
	
	
	
public List<BasicSalary> getAll(){
		
		List<BasicSalary> ls=new LinkedList<>();
		
		try {
		
		Connection con=DBconnection.getconnection();
		
		String Query="select * from test.Promotions p,test.staffTest s where p.empId=s.empId";
		
		
		PreparedStatement ps=con.prepareStatement(Query);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			Promotions promob=new Promotions();
			
			promob.setEmpId(rs.getInt("empId"));
			promob.setDate(rs.getString("date"));
			promob.setPromotion(rs.getDouble("promotion"));
			promob.setName(rs.getString("name"));
			
			
			
//			ls.add(promob);
			
		}
		
		
		
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("we are at get all promotions");
		return ls;	
		
	}
	
	
	

}
