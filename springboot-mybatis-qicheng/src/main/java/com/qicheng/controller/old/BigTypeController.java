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

import com.qicheng.config.ResultStatus;
import com.qicheng.model.ResultModel;
import com.qicheng.old.dao.BigTypeDao;

//商品的Action
@Controller
public class BigTypeController {
	private BigTypeDao dao = new BigTypeDao();
	 
	// 删除大类别的信息 http://localhost:8080/bigTypeDelete?id=1
	@RequestMapping("/bigTypeDelete")
	@ResponseBody
	public ResponseEntity<ResultModel> bigTypeDelete(HttpServletRequest request,HttpServletResponse response) {
		if (dao.deleteBig(Integer.valueOf(request.getParameter("id")))) {
			return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK); //删除大类别信息成功
		} else {
			return new ResponseEntity<>(ResultModel.error(ResultStatus.DELETE_FAIL), HttpStatus.OK); //小类别还存在此信息，请先删除小类别信息
		}
	}

	// 添加大类别的信息 http://localhost:8080/bigTypeInsert?name=1
	@RequestMapping("/bigTypeInsert")
	@ResponseBody
	public ResponseEntity<ResultModel> bigTypeInsert(HttpServletRequest request,HttpServletResponse response) {
		dao.insertBig(request.getParameter("name"));
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}

	// 全部查询商品信息 http://localhost:8080/bigTypeSelect?number=1
	@RequestMapping("/bigTypeSelect")
	@ResponseBody
	public ResponseEntity<ResultModel> bigTypeSelect(HttpServletRequest request,HttpServletResponse response) {
		List list = dao.selectBig();
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
		String number = request.getParameter("number");
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
	
}
