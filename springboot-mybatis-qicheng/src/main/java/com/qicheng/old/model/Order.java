package com.qicheng.old.model;

//订单表的bean
public class Order {
  private String address; //订货地址
  private String bz;//备注信息
  private Integer id;//id
  private String name;//会员的编号
  private String number;//订货单编号
  private String post;//运送方式
  private String reallyName;//会员真实姓名
  private String setMoney;//付款方式
  private String sign;//发送货物是否成功
  private String tel;//订货电话
  private String creaTime;//订单生成时间

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public void setSetMoney(String setMoney) {
    this.setMoney = setMoney;
  }

  public void setReallyName(String reallyName) {
    this.reallyName = reallyName;
  }

  public void setPost(String post) {
    this.post = post;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public void setCreaTime(String creaTime) {
    this.creaTime = creaTime;
  }

  public String getBz() {
    return bz;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getNumber() {
    return number;
  }

  public String getPost() {
    return post;
  }

  public String getReallyName() {
    return reallyName;
  }

  public String getSetMoney() {
    return setMoney;
  }

  public String getSign() {
    return sign;
  }

  public String getTel() {
    return tel;
  }

  public String getCreaTime() {
    return creaTime;
  }
}
