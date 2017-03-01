package com.qicheng.old.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qicheng.old.model.Member;
import com.qicheng.old.tool.JDBConnection;

//对会员表的操作
public class MemberDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public MemberDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }


//以数据库流水号为条件修改会员的密码
  public boolean updatePassword(String password, Integer id) {
    try {
      ps = connection.prepareStatement("update tb_member set password=? where id=?");
      ps.setString(1, password);
      ps.setInt(2, id.intValue());
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }
  }

//找回密码之用
  public Member selectFind(String name, String result) {
    Member member = null;
    try {
      ps = connection.prepareStatement("select * from tb_member where name=? and result=?");
      ps.setString(1, name);
      ps.setString(2, result);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new Member();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(Integer.valueOf(rs.getString(5)));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }

  //全部查询的操作或以会员名称为条件查询信息
  public Member selectMemberForm(String name) {
    Member member = null;
    try {
      ps = connection.prepareStatement("select * from tb_member where name=?");
      ps.setString(1, name);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new Member();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(Integer.valueOf(rs.getString(5)));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }

//删除操作
  public boolean deleteMember(Integer id) {
    try {
      ps = connection.prepareStatement("delete from tb_member where id=?");
      ps.setString(1, id.toString());
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }
  }

//添加信息
  public void insertMember(Member form) {
    try { 
      ps = connection.prepareStatement("insert into tb_member(name,password,reallyName,age,profession,email,question,result) values (?,?,?,?,?,?,?,?)");
      ps.setString(1, form.getName());
      ps.setString(2, form.getPassword());
      ps.setString(3, form.getReallyName());
      ps.setInt(4, form.getAge());
      ps.setString(5, form.getProfession());
      ps.setString(6, form.getEmail());
      ps.setString(7, form.getQuestion());
      ps.setString(8, form.getResult());
      System.out.println("yyw====================="+ps.toString());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //以数据库流水号为条件修改信息
  public void updateMember(Member form) {
    try {
      ps = connection.prepareStatement("update tb_member set name=?,password=?,reallyName=?,age=?,profession=?,email=?,question=?,result=? where id=?");
      ps.setString(1, form.getName());
      ps.setString(2, form.getPassword());
      ps.setString(3, form.getReallyName());
      ps.setString(4, form.getAge().toString());
      ps.setString(5, form.getProfession());
      ps.setString(6, form.getEmail());
      ps.setString(7, form.getQuestion());
      ps.setString(8, form.getResult());
      ps.setString(9, form.getId().toString());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }



//全部查询信息操作
  public List selectMember() {
    List list = new ArrayList();
    Member member = null;
    try {
      ps = connection.prepareStatement("select * from tb_member order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new Member();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(Integer.valueOf(rs.getString(5)));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
        list.add(member);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//以数据库流水号为条件查询信息
  public Member selectOneMember(Integer id) {
    Member member = null;
    try {
      ps = connection.prepareStatement("select * from tb_member where id=?");
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new Member();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(Integer.valueOf(rs.getString(5)));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }




}
