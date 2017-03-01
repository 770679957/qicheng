package com.qicheng.old.model;

//商品bean
public class Goods {
	private Integer big; //商品大类别编号

	private String creaTime; //添加商品时间

	private Float freePrice; //特价价格

	private String from; //商品生产厂商

	private Integer id; //商品编号

	private String introduce; //商品介绍

	private String name; //商品名称

	private Float nowPrice; //现价

	private Integer number; //购买次数

	private Integer small; //小类别的编号

	private String priture;

	private Integer mark;

	public Integer getBig() {
		return big;
	}

	public void setBig(Integer big) {
		this.big = big;
	}

	public String getCreaTime() {
		return creaTime;
	}

	public void setCreaTime(String creaTime) {
		this.creaTime = creaTime;
	}

	public Float getFreePrice() {
		return freePrice;
	}

	public void setFreePrice(Float freePrice) {
		this.freePrice = freePrice;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(Float nowPrice) {
		this.nowPrice = nowPrice;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPriture() {
		return priture;
	}

	public void setPriture(String priture) {
		this.priture = priture;
	}

	public Integer getSmall() {
		return small;
	}

	public void setSmall(Integer small) {
		this.small = small;
	}

}
