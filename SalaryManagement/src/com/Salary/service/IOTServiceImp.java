package com.Salary.service;

import java.util.List;

import com.Salary.model.OT;

public interface IOTServiceImp{

	public  int addOt(OT ot);
	public List<OT> getAll();
	public List<OT> getOtById(int empId,String date);
	public int edit(int empId,String date,int hours);
	public int delete (int empId,String date);
}
