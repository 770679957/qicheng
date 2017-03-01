package com.qicheng.old.model;

//公告信息bean
public class Affiche {
  private String content = "";
  private Integer id = new Integer( -1);
  private String issueTime = "";
  private String name = "";
  public Affiche() {}
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setIssueTime(String issueTime) {
    this.issueTime = issueTime;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public String getIssueTime() {
    return issueTime;
  }

  public String getName() {
    return name;
  }

}
