package com.qicheng.old.model;

//商品大类别bean
public class BigType {
  private String bigName="";
  private String creaTime="";
  private Integer id=Integer.valueOf("-1");
  public BigType(){}
  public String getBigName() {
    return bigName;
  }

  public void setBigName(String bigName) {
    this.bigName = bigName;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setCreaTime(String creaTime) {
    this.creaTime = creaTime;
  }

  public String getCreaTime() {
    return creaTime;
  }

  public Integer getId() {
    return id;
  }

}
