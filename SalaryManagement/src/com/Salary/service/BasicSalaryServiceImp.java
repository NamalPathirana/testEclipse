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
	
	
	public int addBS(BasicSalary bs) {
		
		String addOtQuery="insert into basicSalary (position,date,basicSalary) values(?,?,?)";
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
	
	
	
	
	public List<BasicSalary> getAllBasicSalary(){
		
		List<BasicSalary> ls=new LinkedList<>();
		
		try {
		
		Connection con=DBconnection.getconnection();
		
		String Query="select * from BasicSalary ";
		
		
		PreparedStatement ps=con.prepareStatement(Query);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			BasicSalary bs=new BasicSalary();
			
			bs.setDate(rs.getString("date"));
			bs.setPostion(rs.getString("position"));
			bs.setBasicsalary(rs.getDouble("basicSalary"));
			
			
			
			ls.add(bs);
			
		}
		
		
		
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("we are at get all promotions");
		return ls;	
		
	}
	
	
	public List<BasicSalary> getBasicSalaryById(String position){
		
		List<BasicSalary> ls=new LinkedList<>();
		
		try {
		
		Connection con=DBconnection.getconnection();
		
		String Query="select * from BasicSalary b where  b.position= ? ";
		
		
		PreparedStatement ps=con.prepareStatement(Query);
		
		System.out.println(position+"   position");
		
		ps.setString(1,position);
		
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			BasicSalary bs=new BasicSalary();
			
			bs.setPostion(rs.getString("position"));
			bs.setDate(rs.getString("date"));
			bs.setBasicsalary(Double.parseDouble(rs.getString("basicSalary")));
			
			
			
			ls.add(bs);
			
		}
		
		
		
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	
		return ls;	
		
	}
	
	public int edit(String position,String date,double bs) {
		
		
		String sql="update BasicSalary set BasicSalary=?,date=?"+" where position=?";
		PreparedStatement ps;
		int rows=0;
		
		try {
			Connection con=DBconnection.getconnection();
			ps=con.prepareStatement(sql);
			
			ps.setDouble(1,bs);
			ps.setString(2,date);
			ps.setString(3,position);
			
		
			rows=ps.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return rows;
		
		
		
	}
	
	
	public int deleteBS(String position) {
		
		String sql="delete from BasicSalary where position =? ";
		int rows=0;
		
		try {
			Connection con =DBconnection.getconnection();
			PreparedStatement ps=con.prepareStatement(sql);
		
			ps.setString(1,position);
	
		
			rows=ps.executeUpdate();
		
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rows;
		
		
	}
	
	
	
	
	
	
	

}
