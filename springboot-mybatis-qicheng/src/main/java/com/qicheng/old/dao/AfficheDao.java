package com.qicheng.old.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qicheng.old.model.Affiche;
import com.qicheng.old.tool.JDBConnection;

//对公告信息的操作
public class AfficheDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public AfficheDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

  //删除的方法
  public void deleteAffiche(Integer id) {
    try {
      ps = connection.prepareStatement("delete from tb_affiche where id=?");
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //修改的方法
  public void updateAffiche(Affiche form) {
    try {
      ps = connection.prepareStatement("update tb_affiche set name=?,content=? where id=?");
      ps.setString(1, form.getName());
      ps.setString(2, form.getContent());
      ps.setInt(3, form.getId().intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//添加的方法
  public void insertAffiche(Affiche form) {
    try {
      ps = connection.prepareStatement("insert into tb_affiche values (?,?,getDate())");
      ps.setString(1, form.getName());
      ps.setString(2, form.getContent());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//以数据库流水号为条件查询信息
  public Affiche selectOneAffiche(Integer id) {
    Affiche affiche = null;
    try {
      ps = connection.prepareStatement("select * from tb_affiche where id=?");
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        affiche = new Affiche();
        affiche.setId(Integer.valueOf(rs.getString(1)));
        affiche.setName(rs.getString(2));
        affiche.setContent(rs.getString(3));
        affiche.setIssueTime(rs.getString(4));
      }
    }
    catch (SQLException ex) {
    }
    return affiche;
  }

//全部查询的方法
  public List selectAffiche() {
    List list = new ArrayList();
    Affiche affiche = null;
    try {
      ps = connection.prepareStatement("select * from tb_affiche order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        affiche = new Affiche();
        affiche.setId(Integer.valueOf(rs.getString(1)));
        affiche.setName(rs.getString(2));
        affiche.setContent(rs.getString(3));
        affiche.setIssueTime(rs.getString(4));
        list.add(affiche);
      }
    }
    catch (SQLException ex) {
    }
    return list;

  }

}
