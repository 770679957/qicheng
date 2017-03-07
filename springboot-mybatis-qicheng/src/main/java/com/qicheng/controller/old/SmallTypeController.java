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
import com.qicheng.old.dao.SmallTypeDao;
import com.qicheng.old.model.SmallType;

//商品小类别信息
@Controller
public class SmallTypeController {
	private SmallTypeDao dao =  new SmallTypeDao();
	
	
	// 以外键编号为条件修改小类别信息 http://localhost:8080/smallTypeSelectBigId?bigId=1&number=1
	@RequestMapping("/smallTypeSelectBigId")
	@ResponseBody
	public ResponseEntity<ResultModel> smallTypeSelectBigId(HttpServletRequest request,HttpServletResponse response) {
		List list = dao.selectOneBigId(Integer.valueOf(request.getParameter("bigId")));
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
	
	
	// 以数据库流水号为条件修改小类别信息 http://localhost:8080/smallTypeUpdate?bigId=1&id=1&name=1
	@RequestMapping("/smallTypeUpdate")
	@ResponseBody
	public ResponseEntity<ResultModel> smallTypeUpdate(HttpServletRequest request,HttpServletResponse response) {
		SmallType smallType = new SmallType();
		smallType.setBigId(Integer.valueOf(request.getParameter("bigId")));
		smallType.setId(Integer.valueOf(request.getParameter("id")));
		smallType.setSmallName(request.getParameter("name"));
		dao.updateSmall(smallType);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
	
	// 以数据库流水号为条件查询小类别信息 http://localhost:8080/smallTypeSelectOne?id=1
	@RequestMapping("/smallTypeSelectOne")
	@ResponseBody
	public ResponseEntity<ResultModel> smallTypeSelectOne(HttpServletRequest request,HttpServletResponse response) {
		return new ResponseEntity<>(ResultModel.ok(dao.selectOneBig(Integer.valueOf(request.getParameter("id")))), HttpStatus.OK);
	}
	
	// 删除小类别信息 http://localhost:8080/smallTypeDelete?id=1
	@RequestMapping("/smallTypeDelete")
	@ResponseBody
	public ResponseEntity<ResultModel> smallTypeDelete(HttpServletRequest request,HttpServletResponse response) {
		if (dao.deleteSmall(Integer.valueOf(request.getParameter("id")))) {
			return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK); //删除小类别信息成功！
		} else {
			return new ResponseEntity<>(ResultModel.error(ResultStatus.FAIL), HttpStatus.OK); //商品信息还存在此类别，请先删除商品信息！！！
		}
	}
	
	// 添加小类别信息 http://localhost:8080/smallTypeInsert?bigId=1&name=1
	@RequestMapping("/smallTypeInsert")
	@ResponseBody
	public ResponseEntity<ResultModel> smallTypeInsert(HttpServletRequest request,HttpServletResponse response) {
		SmallType smallTypeForm = new SmallType();
		smallTypeForm.setBigId(Integer.valueOf(request.getParameter("bigId")));
		smallTypeForm.setSmallName(request.getParameter("name"));
		dao.insertSmall(smallTypeForm);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK); 
	}
	
	// 全部查询小类别信息 http://localhost:8080/smallTypeSelect?map=1
	@RequestMapping("/smallTypeSelect")
	@ResponseBody
	public ResponseEntity<ResultModel> smallTypeSelect(HttpServletRequest request,HttpServletResponse response) {
		List list = dao.selectSmall();
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
	//end
}
