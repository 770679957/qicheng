package com.qicheng.old.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qicheng.old.model.Goods;
import com.qicheng.old.tool.JDBConnection;

//对商品表的操作
public class GoodsDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public GoodsDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

//根据商品的ID修改购买商品的数量
  public void updateGoodsNumber(int number, Integer id) {
    try {
      ps = connection.prepareStatement("update tb_goods set number=number+? where id=?");
      ps.setInt(1, number);
      ps.setInt(2, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }

  }

//设置特价价格的方法
  public void managerPrice(Goods form) {
    try {
      ps = connection.prepareStatement("update tb_goods set freePrice=?,mark=? where id=?");
      ps.setFloat(1, form.getFreePrice().floatValue());
      ps.setInt(2, form.getMark().intValue());
      ps.setInt(3, form.getId().intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //以商品的是否特价为条件查询信息
  public List selectMark(Integer mark) {
    List list = new ArrayList();
    Goods goods = null;
    try {
      ps = connection.prepareStatement("select * from tb_goods where mark=? order by id DESC");
      ps.setInt(1, mark.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new Goods();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//添加操作
  public void insertGoods(Goods form) {
    try {
     // ps = connection.prepareStatement("insert into tb_goods values (?,?,?,?,?,getDate(),?,?,?,?,?)");
      ps = connection.prepareStatement("insert into tb_goods(bigId,smallId,goodsName,goodsFrom,introduce,creaTime,nowPrice,freePrice,number,pirture,mark) values (?,?,?,?,?,now(),?,?,?,?,?)");
      ps.setInt(1, form.getBig().intValue());
      ps.setInt(2, form.getSmall().intValue());
      ps.setString(3, form.getName());
      ps.setString(4, form.getFrom());
      ps.setString(5, form.getIntroduce());
      ps.setFloat(6, form.getNowPrice().floatValue());
      ps.setFloat(7, form.getFreePrice().floatValue());
      ps.setInt(8, 0);
      ps.setString(9, form.getPriture());
      ps.setInt(10, 0);
      System.out.println("yyw====================="+ps.toString());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//以商品编号为条件删除信息
  public void deleteGoods(Integer id) {
    try {
      ps = connection.prepareStatement("delete from tb_goods where id=?");
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//以商品的编号为条件查询信息
  public Goods selectOneGoods(Integer id) {
    Goods goods = new Goods();
    try {
      ps = connection.prepareStatement("select * from tb_goods where id=? order by id DESC");
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {   
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
      }
    }
    catch (SQLException ex) {
    }
    return goods;
  }

  //以商品的小类别的编号为条件查询信息
  public List selectSmall(Integer small) {
    List list = new ArrayList();
    Goods goods = null;
    try {
      ps = connection.prepareStatement("select * from tb_goods where smallId=? order by id DESC");
      ps.setInt(1, small.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new Goods();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

  //以商品的大类别的编号为条件查询信息
  public List selectBig(Integer big) {
    List list = new ArrayList();
    Goods goods = null;
    try {
      ps = connection.prepareStatement("select * from tb_goods where bigId=? order by id DESC");
      ps.setInt(1, big.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new Goods();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//全部查询
  public List selectGoods() {
    List list = new ArrayList();
    Goods goods = null;
    try {
      ps = connection.prepareStatement("select * from tb_goods order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new Goods();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

  //全部查询
  public List selectGoodsNumber() {
    List list = new ArrayList();
    Goods goods = null;
    try {
      ps = connection.prepareStatement("select * from tb_goods order by number DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new Goods();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }


}
