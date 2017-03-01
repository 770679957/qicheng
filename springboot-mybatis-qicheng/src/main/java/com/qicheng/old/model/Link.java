package com.qicheng.old.model;

//友情连接网站的Bean
public class Link {
	private Integer id = -1; // 数据库流水号

	private String linkAddress = ""; // 连接地址

	private String linkName = ""; // 连接名称

	public Link() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	public String getLinkAddress() {
		return linkAddress;
	}

	public String getLinkName() {
		return linkName;
	}
}
