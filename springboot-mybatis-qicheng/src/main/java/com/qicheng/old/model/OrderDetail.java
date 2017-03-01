package com.qicheng.old.model;

//订单明细表的bean
public class OrderDetail {
  private Integer goodsId;//商品编号
  private Integer id; //id
  private String orderNumber;//订单编号
  private float price;//价格

  private int number;//订货数量

  public Integer getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Integer goodsId) {
    this.goodsId = goodsId;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public int getNumber() {
    return number;
  }

  public float getPrice() {
    return price;
  }
}
