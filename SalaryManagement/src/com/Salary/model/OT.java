package com.Salary.model;

public class OT {
	
	private int empID;
	private String date;
	private int hours;
	
	
	
	public OT(int empId, String date, int hours) {
		super();
		this.empID = empId;
		this.date = date;
		this.hours = hours;
	}
	
	
	

	
	@Override
	public String toString() {
		return "OT [empID=" + empID + ", date=" + date + ", hours=" + hours + "]";
	}



	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	
	


}
