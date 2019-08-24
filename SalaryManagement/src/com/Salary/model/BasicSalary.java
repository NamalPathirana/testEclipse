package com.Salary.model;

public class BasicSalary {
	
	
	private String postion;
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
