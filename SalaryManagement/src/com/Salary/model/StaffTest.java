package com.Salary.model;

public class StaffTest {

	private int empID;
	private String position;
	
	

	
	
	
	public StaffTest(int empID, String position) {
		super();
		this.empID = empID;
		this.position = position;
	}





	@Override
	public String toString() {
		return "StaffTest [empID=" + empID + ", position=" + position + "]";
	}





	public int getEmpID() {
		return empID;
	}





	public void setEmpID(int empID) {
		this.empID = empID;
	}





	public String getPosition() {
		return position;
	}





	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	
}
