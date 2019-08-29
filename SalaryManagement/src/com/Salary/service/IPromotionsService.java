package com.Salary.service;

import java.util.List;

import com.Salary.model.Promotions;

public interface IPromotionsService {

	public int addOt(Promotions prom);
	public List<Promotions> getAll();
	public List<Promotions> getPromotionById(int empId);
	public int delete (int empId);
	public int edit(int empId,String date,double promotion);
	
}
