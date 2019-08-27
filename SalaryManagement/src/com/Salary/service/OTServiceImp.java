package com.Salary.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.Salary.model.OT;
import com.Salary.utility.DBconnection;
import com.mysql.cj.xdevapi.PreparableStatement;





public class OTServiceImp implements IOTServiceImp {

	
	
	public int addOt(OT ot) {
		
		String addOtQuery="insert into OT(empid,date,hours) values(?,?,?)";
		int rows=0;
		
		Connection DB;
		try {
			
			DB = DBconnection.getconnection();
			PreparedStatement ps=DB.prepareStatement(addOtQuery);
			
			ps.setInt(1,ot.getEmpID());
			
//			Date datetemp=new Date(System.currentTimeMillis());
//			SimpleDateFormat dataFormat =new SimpleDateFormat("yyyy/MM/dd");
//			String date =dateFormat.format(datetemp.get);
			
//			String dateReceivedFromUser =ot.getDate();
//			DateFormat userDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//			DateFormat dateFormatNeeded = new SimpleDateFormat("yyyy-MM-dd");
//			Date date = userDateFormat.parse(dateReceivedFromUser);
//			String convertedDate = dateFormatNeeded.format(date);

			ps.setString(2,ot.getDate());
			ps.setInt(3,ot.getHours());
			
			rows=ps.executeUpdate();
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;	
		
	}
	
	
	
	public List<OT> getAll(){
		
		List<OT> ls=new LinkedList<>();
		
		try {
		
		Connection con=DBconnection.getconnection();
		
		String Query="select * from OT";
		
		
		PreparedStatement ps=con.prepareStatement(Query);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			OT otobject=new OT(rs.getInt("empid"),rs.getString("date"),rs.getInt("hours"));
			
			ls.add(otobject);
			
		}
		
		
		
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	
		return ls;	
		
	}
	
	public List<OT> getOtById(int empId,String date){
		
		List<OT> ls=new LinkedList<>();
		
		try {
		
		Connection con=DBconnection.getconnection();
		
		String Query="select * from OT where empid = ? AND date =? ";
		
		
		PreparedStatement ps=con.prepareStatement(Query);
		
		ps.setInt(1,empId);
		ps.setString(2,date);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			OT otobject=new OT(rs.getInt("empId"),rs.getString("date"),rs.getInt("hours"));
			
			ls.add(otobject);
			
		}
		
		
		
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	
		return ls;	
		
	}
	
	
	public int edit(int empId,String date,int hours) {
		
		
		String sql="update OT set hours =? "+" where empId=? and date = ?";
		PreparedStatement ps;
		int rows=0;
		
		try {
			Connection con=DBconnection.getconnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1,hours);
			ps.setInt(2,empId);
			ps.setString(3,date);
		
			rows=ps.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return rows;
		
		
		
	}
	
	public int delete (int empId,String date) {
		
		String sql="delete from OT where empId =? and date =?";
		int rows=0;
		
		try {
			Connection con =DBconnection.getconnection();
			PreparedStatement ps=con.prepareStatement(sql);
		
			ps.setInt(1,empId);
			ps.setString(2,date);
		
			rows=ps.executeUpdate();
		
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rows;
		
		
	}

	
//	public static void main(String args[]) {
//		List<OT> ls=new LinkedList<>();
//	
//		int empId=100;
//		String date="2019-08-25";
//		
//		try {
//		
//		Connection con=DBconnection.getconnection();
//		
//		String Query="select * from OT where empid = ? AND date =? ";
//
//		
//		
//		PreparedStatement ps=con.prepareStatement(Query);
//		
//		ps.setInt(1,empId);
//		ps.setString(2,date);
//		
//		
//		ResultSet rs=ps.executeQuery();
//		
//		while(rs.next()) {
//			
//			OT otobject=new OT(rs.getInt("empId"),rs.getString("date"),rs.getInt("hours"));
//			
//			ls.add(otobject);
//			
//		}
//		
//		
//		
//		} catch (SQLException | ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		}
//		
//	
//	
//		System.out.println(ls);
//		
//		
//		
//		
//	}









}
