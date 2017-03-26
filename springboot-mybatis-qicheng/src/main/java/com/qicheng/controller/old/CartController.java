package com.qicheng.controller.old;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qicheng.config.ResultStatus;
import com.qicheng.model.ResultModel;
import com.qicheng.old.dao.GoodsDao;
import com.qicheng.old.model.Goods;

// 购物车 
@Controller 
public class CartController{
	private GoodsDao goodsDao;
	
	// 向购物车中添加商品
	@RequestMapping("/cartAdd")
	@ResponseBody
	public ResponseEntity<ResultModel> cartAdd(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = request.getParameter("goodsID");
		Goods goods = goodsDao.selectOneGoods(Integer.valueOf(id));
		Goods myGoodsElement = new Goods();
		myGoodsElement.setId(goods.getId());
		myGoodsElement.setName(goods.getName());
		myGoodsElement.setNowPrice(goods.getNowPrice());
		myGoodsElement.setNumber(1);
		List<Goods> cart = (List<Goods>) session.getAttribute("cart");
		boolean Flag = true;
		if (cart == null) {
			cart = new ArrayList<Goods>();
		} else {
			for (int i = 0; i < cart.size(); i++) {
				Goods goodsitem = cart.get(i);
				if (goodsitem.getId() == myGoodsElement.getId()) {
					goodsitem.setNumber(goodsitem.getNumber() + 1);
					Flag = false;
				}
			}
		}
		if (Flag) {
			cart.add(myGoodsElement);
			session.setAttribute("cart", cart);
		}
		return new ResponseEntity<>(ResultModel.ok(cart), HttpStatus.OK);
	}
	
	//修改购物车，商品数量
	@RequestMapping("/cartModify")
	@ResponseBody
	public ResponseEntity<ResultModel> cartModify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		List<Goods> cart = (List<Goods>) session.getAttribute("cart");
		for (int i = 0; i < cart.size(); i++) {
			Goods myGoodsElement = cart.get(i);
			String num = request.getParameter("num" + i);
			int newnum = Integer.parseInt(num);
			myGoodsElement.setNumber(newnum);
			if (newnum <= 0) {
				cart.remove(myGoodsElement);
			}
		}
		return new ResponseEntity<>(ResultModel.ok(ResultStatus.UPDATE_SUCCESS), HttpStatus.OK);
	}
	
	//清空购物车
	@RequestMapping("/cartClear")
	@ResponseBody
	public ResponseEntity<ResultModel>  cartClear(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
		return new ResponseEntity<>(ResultModel.ok(ResultStatus.UPDATE_SUCCESS), HttpStatus.OK);
	}
	
	//从购物车中删除
	@RequestMapping("/cartMove")
	@ResponseBody
	public ResponseEntity<ResultModel> cartMove(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		List cart = (List) session.getAttribute("cart");
		int id = Integer.parseInt(request.getParameter("ID"));
		cart.remove(id);
		return new ResponseEntity<>(ResultModel.ok(cart), HttpStatus.OK);
	}

}
