package com.qicheng.old.model;

//购货商品的bean
public class SellGoods {
	public int ID; // 商品ID
	public float price; // 价格
	public int number; // 数量

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
