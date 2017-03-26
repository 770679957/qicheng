package com.qicheng.old.model;

// 折扣
public class Rebate {
	private String grade; //id

	private Double amount; //总额

	private Float rebate; //折扣

	public Rebate() {
	}

	public Rebate(String grade, Double amount, Float rebate) {
		this.grade = grade;
		this.amount = amount;
		this.rebate = rebate;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Float getRebate() {
		return this.rebate;
	}

	public void setRebate(Float rebate) {
		this.rebate = rebate;
	}

}