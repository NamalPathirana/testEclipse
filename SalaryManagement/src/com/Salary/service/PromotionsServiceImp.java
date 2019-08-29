package com.Salary.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.Salary.model.OT;
import com.Salary.model.Promotions;
import com.Salary.utility.DBconnection;

public class PromotionsServiceImp implements IPromotionsService{

	
	
	public int addOt(Promotions prom) {
		
		String addOtQuery="insert into Promotions (empId,date,promotion) values(?,?,?)";
		int rows=0;
		
		Connection DB;
		try {
			
			DB = DBconnection.getconnection();
			PreparedStatement ps=DB.prepareStatement(addOtQuery);
			
			ps.setInt(1,prom.getEmpId());
			ps.setString(2,prom.getDate());
			ps.setDouble(3,prom.getPromotion());
			
			rows=ps.executeUpdate();
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;	
		
	}
	
	public List<Promotions> getAll(){
		
		List<Promotions> ls=new LinkedList<>();
		
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
			
			
			
			ls.add(promob);
			
		}
		
		
		
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("we are at get all promotions");
		return ls;	
		
	}
	
	
	public List<Promotions> getPromotionById(int empId){
		
		List<Promotions> ls=new LinkedList<>();
		
		try {
		
		Connection con=DBconnection.getconnection();
		
		String Query="select * from test.Promotions p,test.staffTest s where p.empId=s.empId and p.empid= ? ";
		
		
		PreparedStatement ps=con.prepareStatement(Query);
		
		ps.setInt(1,empId);
		
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			Promotions promobj=new Promotions();
			
			promobj.setEmpId(rs.getInt("empId"));
			promobj.setDate(rs.getString("date"));
			promobj.setName(rs.getString("name"));
			promobj.setPromotion(rs.getDouble("promotion"));
			
			
			ls.add(promobj);
			
		}
		
		
		
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	
		return ls;	
		
	}
	
	public int edit(int empId,String date,double promotion) {
		
		
		String sql="update Promotions set promotion=?,date=? "+" where empId=? ";
		PreparedStatement ps;
		int rows=0;
		
		try {
			Connection con=DBconnection.getconnection();
			ps=con.prepareStatement(sql);
			
			ps.setDouble(1,promotion);
			ps.setString(2,date);
			ps.setInt(3,empId);
			
		
			rows=ps.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return rows;
		
		
		
	}
	
	public int delete (int empId) {
		
		String sql="delete from Promotions where empId =? ";
		int rows=0;
		
		try {
			Connection con =DBconnection.getconnection();
			PreparedStatement ps=con.prepareStatement(sql);
		
			ps.setInt(1,empId);
	
		
			rows=ps.executeUpdate();
		
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rows;
		
		
	}
	
	
	
	
	
	
	
	
}
