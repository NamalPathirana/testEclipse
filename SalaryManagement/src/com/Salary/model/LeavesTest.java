package com.Salary.model;

public class LeavesTest {
	
	private int recordID;
	private int eID;
	private String date;
	private int noOfdays;
	
	
	
	
	
	public LeavesTest(int recordID, int eID, String date, int noOfdays) {
		super();
		this.recordID = recordID;
		this.eID = eID;
		this.date = date;
		this.noOfdays = noOfdays;
	}
	@Override
	public String toString() {
		return "LeavesTest [recordID=" + recordID + ", eID=" + eID + ", date=" + date + ", noOfdays=" + noOfdays + "]";
	}
	public int getRecordID() {
		return recordID;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}
	public int geteID() {
		return eID;
	}
	public void seteID(int eID) {
		this.eID = eID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNoOfdays() {
		return noOfdays;
	}
	public void setNoOfdays(int noOfdays) {
		this.noOfdays = noOfdays;
	}
	
	
	
	
	

}
