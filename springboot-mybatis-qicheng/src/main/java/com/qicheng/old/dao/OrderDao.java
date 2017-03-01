package com.qicheng.old.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qicheng.old.model.Order;
import com.qicheng.old.tool.JDBConnection;

//订货表的操作
public class OrderDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public OrderDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

//前台订货查询
  public List selectOrderHead(String name) {
  List list=new ArrayList();
    Order order = null;
   try {
     ps = connection.prepareStatement("select * from tb_order where name=?");
     ps.setString(1, name);
     ResultSet rs = ps.executeQuery();
     while (rs.next()) {
       order = new Order();
       order.setId(Integer.valueOf(rs.getString(1)));
       order.setNumber(rs.getString(2));
       order.setName(rs.getString(3));
       order.setReallyName(rs.getString(4));
       order.setAddress(rs.getString(5));
       order.setTel(rs.getString(6));
       order.setSetMoney(rs.getString(7));
       order.setPost(rs.getString(8));
       order.setBz(rs.getString(9));
       order.setSign(rs.getString(10));
       order.setCreaTime(rs.getString(11));
       list.add(order);

     }
   }
   catch (SQLException ex) {
   }
   return list;
 }



  //以订货编号为条件查询信息
  public Order selectOrderNumber(String number) {

    Order order = null;
    try {
      ps = connection.prepareStatement("select * from tb_order where number=?");
      ps.setString(1, number);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        order = new Order();
        order.setId(Integer.valueOf(rs.getString(1)));
        order.setNumber(rs.getString(2));
        order.setName(rs.getString(3));
        order.setReallyName(rs.getString(4));
        order.setAddress(rs.getString(5));
        order.setTel(rs.getString(6));
        order.setSetMoney(rs.getString(7));
        order.setPost(rs.getString(8));
        order.setBz(rs.getString(9));
        order.setSign(rs.getString(10));
        order.setCreaTime(rs.getString(11));

      }
    }
    catch (SQLException ex) {
    }
    return order;
  }

  //出货操作
  public void updateSignOrder(String number) {
    try {
      ps = connection.prepareStatement("update tb_order set sign=1 where number=?");
      ps.setString(1, number);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }

  }

//删除订货信息
  public boolean deleteOrder(String number) {
    try {
      ps = connection.prepareStatement("delete from tb_order where number=?");
      ps.setString(1, number);
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }

  }

//以订货标记为条件查询信息
  public List selectOrderSign(Integer id) {
    List list = new ArrayList();
    Order order = null;
    try {
      if (id == null) {
        ps = connection.prepareStatement("select * from tb_order order by id DESC");
      }
      else {
        ps = connection.prepareStatement("select * from tb_order where sign=? order by id DESC");
        ps.setInt(1, id.intValue());
      }
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        order = new Order();
        order.setId(Integer.valueOf(rs.getString(1)));
        order.setNumber(rs.getString(2));
        order.setName(rs.getString(3));
        order.setReallyName(rs.getString(4));
        order.setAddress(rs.getString(5));
        order.setTel(rs.getString(6));
        order.setSetMoney(rs.getString(7));
        order.setPost(rs.getString(8));
        order.setBz(rs.getString(9));
        order.setSign(rs.getString(10));
        order.setCreaTime(rs.getString(11));
        list.add(order);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//添加的方法
  public void insertOrderDetail(Order form) {
    try {
      ps = connection.prepareStatement("insert into tb_order values (?,?,?,?,?,?,?,?,?,getDate())");
      ps.setString(1, form.getNumber());
      ps.setString(2, form.getName());
      ps.setString(3, form.getReallyName());
      ps.setString(4, form.getAddress());
      ps.setString(5, form.getTel());
      ps.setString(6, form.getSetMoney());
      ps.setString(7, form.getPost());
      ps.setString(8, form.getBz());
      ps.setString(9, form.getSign());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {

    }
  }
}
