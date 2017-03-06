package com.qicheng.controller.old;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qicheng.model.ResultModel;
import com.qicheng.old.dao.OrderDao;
import com.qicheng.old.dao.OrderDetailDao;

//后台订单管理的Action
@Controller
public class OrderController {
	private OrderDao order = new OrderDao();
	private OrderDetailDao orderDetail = new OrderDetailDao();

	// 查询订单的详细信息 http://localhost:8080/selectOneOrder?number=1
	@RequestMapping("/selectOneOrder")
	@ResponseBody
	public ResponseEntity<ResultModel> selectOneOrder(HttpServletRequest request,HttpServletResponse response) {
		String number = request.getParameter("number");
		Map<String,Object> map = new HashMap<>();
		map.put("orderForm", order.selectOrderNumber(number));
		map.put("orderDetailList", orderDetail.selectOrderDetailNumber(number));
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}
	
	// 删除出货信息 http://localhost:8080/deleteOrder?number=2
	@RequestMapping("/deleteOrder")
	@ResponseBody
	public ResponseEntity<ResultModel> deleteOrder(HttpServletRequest request, HttpServletResponse response) {
		String number = (String) request.getParameter("number");
		orderDetail.deleteOrderDetail(number);
		order.deleteOrder(number);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
	
	// 出货 http://localhost:8080/selectOrderSend?number=2
	@RequestMapping("/selectOrderSend")
	public ModelAndView selectOrderSend(HttpServletRequest request,HttpServletResponse response) {
		String number = request.getParameter("number");
		order.updateSignOrder(request.getParameter("number"));
		//selectOrder(mapping, form, request, response);
		// return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
		return new ModelAndView("redirect:/selectOrder?dnumber="+number);
	}
	
	// 查询所有的订单 http://localhost:8080/selectOrder?number=1&sign=2
	@RequestMapping("/selectOrder")
	@ResponseBody
	public ResponseEntity<ResultModel> selectOrder(HttpServletRequest request,HttpServletResponse response) {
		Integer sign = null;
		if (request.getParameter("sign") != null) {
			sign = Integer.valueOf(request.getParameter("sign"));
		}
		List list = order.selectOrderSign(sign);
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
		String number = request.getParameter("i");
		if (maxPage % 6 == 0) {
			maxPage = maxPage / 6;
		} else {
			maxPage = maxPage / 6 + 1;
		}
		if (number == null) {
			number = "0";
		}
		Map<String,Object> map = new HashMap<>();
		map.put("number", String.valueOf(number));
		map.put("maxPage", String.valueOf(maxPage));
		map.put("pageNumber", String.valueOf(pageNumber));
		map.put("list", list);
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}
 //end
}
