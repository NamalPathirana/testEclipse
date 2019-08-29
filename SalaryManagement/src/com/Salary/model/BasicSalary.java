package com.Salary.model;

public class BasicSalary {
	
	
	private String postion;
	private String date;
	private double basicsalary;
	
	
	
	



//	public BasicSalary(String postion, double basicsalary) {
//		super();
//		this.postion = postion;
//		this.basicsalary = basicsalary;
//	}
//	
	
	
	
	
	
	public String getPostion() {
		return postion;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setPostion(String postion) {
		this.postion = postion;
	}
	public double getBasicsalary() {
		return basicsalary;
	}
	public void setBasicsalary(double basicsalary) {
		this.basicsalary = basicsalary;
	}
	
	@Override
	public String toString() {
		return "BasicSalary [postion=" + postion + ", basicsalary=" + basicsalary + "]";
	}
	
	
	
	
	
	

}
