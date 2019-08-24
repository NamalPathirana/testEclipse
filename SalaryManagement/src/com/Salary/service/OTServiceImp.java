package com.Salary.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.Salary.model.OT;
import com.Salary.utility.DBconnection;





public class OTServiceImp implements IOTServiceImp {

	
	
	public void addOt(OT ot) {
		
		String addOtQuery="insert into OT(empid,date,hours) values(?,?,?)";
		
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
			
			ps.executeUpdate();
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
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

	
//	public static void main(String args[]) {
//		
//		List<OT> ls=new LinkedList<>();
//		
//		try {
//		
//		Connection con=DBconnection.getconnection();
//		
//		String Query="select * from OT";
//		
//		
//		PreparedStatement ps=con.prepareStatement(Query);
//		
//		ResultSet rs=ps.executeQuery();
//		
//		while(rs.next()) {
//			
//			OT otobject=new OT(rs.getInt("empid"),rs.getString("date"),rs.getInt("hours"));
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
//		System.out.println(ls);
//		
//		
//		
//		
//	}









}
