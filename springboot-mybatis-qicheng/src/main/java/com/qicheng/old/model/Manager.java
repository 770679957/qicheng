package com.qicheng.old.model;

//管理员bean
public class Manager {
  private String account="";//管理员账号
  private Integer id=Integer.valueOf("-1");//数据库流水号
  private String name="";//管理员名称
  private String password="";//管理员登录密码
  private Integer sigh=Integer.valueOf("-1");//管理员标识（1：是、0否）
 //构造方法
  public Manager(){}


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public void setSigh(Integer sigh) {
    this.sigh = sigh;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public Integer getSigh() {
    return sigh;
  }
 
}
