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
import com.qicheng.old.dao.AfficheDao;
import com.qicheng.old.model.Affiche;

//公告信息的Action 
@Controller
public class AfficheController {
	
	private AfficheDao dao = new AfficheDao();
	
	// 以数据库流水号为条件查询公告信息的内容 http://localhost:8080/afficheContent?id=2
	@RequestMapping("/afficheContent")
	@ResponseBody
	public ResponseEntity<ResultModel> afficheContent(HttpServletRequest request, HttpServletResponse response) {
		return new ResponseEntity<>(ResultModel.ok(dao.selectOneAffiche(Integer.valueOf(request.getParameter("id")))), HttpStatus.OK);
	}
	
	// 以数据库流水号为条件查询公告信息 http://localhost:8080/afficheSelectOne?id=2
	@RequestMapping("/afficheSelectOne")
	@ResponseBody
	public ResponseEntity<ResultModel> afficheSelectOne(HttpServletRequest request, HttpServletResponse response) {
		return new ResponseEntity<>(ResultModel.ok(dao.selectOneAffiche(Integer.valueOf(request.getParameter("id")))), HttpStatus.OK);
	}
	
	// 以数据库流水号为条件修改公告信息 http://localhost:8080/afficheUpdate?name=1&content=2&w&id=2
	@RequestMapping("/afficheUpdate")
	@ResponseBody
	public ResponseEntity<ResultModel> afficheUpdate(Affiche afficheForm,HttpServletRequest request, HttpServletResponse response) {
		dao.updateAffiche(afficheForm);
		return new ResponseEntity<>(ResultModel.ok(ResultStatus.UPDATE_SUCCESS), HttpStatus.OK);
	}
	
	// 对公告信息的全部查询功能 http://localhost:8080/afficheSelect?number=1
	@RequestMapping("/afficheSelect")
	@ResponseBody
	public ResponseEntity<ResultModel> afficheSelect(HttpServletRequest request, HttpServletResponse response) {
		List list = dao.selectAffiche();
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
		String number = request.getParameter("number");
		if (maxPage % 7 == 0) {
			maxPage = maxPage / 7;
		} else {
			maxPage = maxPage / 7 + 1;
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
	
	// 添加公告信息 http://localhost:8080/afficheInsert?name=1&content=1
	@RequestMapping("/afficheInsert")
	@ResponseBody
	public ResponseEntity<ResultModel> afficheInsert(Affiche afficheForm,HttpServletRequest request, HttpServletResponse response) {
		dao.insertAffiche(afficheForm);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
	
	// 以数据库流水号为条件删除公告信息 http://localhost:8080/afficheDelete?id=1
	@RequestMapping("/afficheDelete")
	@ResponseBody
	public ResponseEntity<ResultModel> afficheDelete(HttpServletRequest request, HttpServletResponse response) {
		dao.deleteAffiche(Integer.valueOf(request.getParameter("id")));
		return new ResponseEntity<>(ResultModel.ok(ResultStatus.DELETE_SUCCESS), HttpStatus.OK);
	}
	
	//end
}
