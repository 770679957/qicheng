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
import com.qicheng.old.dao.LinkDao;
import com.qicheng.old.model.Link;

//网站连接的Action
@Controller
public class LinkController {
	private LinkDao dao = new LinkDao();

	// 删除网站信息 http://localhost:8080/linkDelete?id=2
	@RequestMapping("/linkDelete")
	@ResponseBody
	public ResponseEntity<ResultModel> linkDelete(HttpServletRequest request,HttpServletResponse response) {
		dao.deleteLink(Integer.valueOf(request.getParameter("id")));
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
	
	// 添加网站信息 http://localhost:8080/linkInsert?linkName=2&linkAddress=2
	@RequestMapping("/linkInsert")
	@ResponseBody
	public ResponseEntity<ResultModel> linkInsert(Link linkForm,HttpServletRequest request,HttpServletResponse response) {
		dao.insertLink(linkForm);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}

	// 对连接网站地址信息的全部查询 http://localhost:8080/linkSelect?number=1
	@RequestMapping("/linkSelect")
	@ResponseBody
	public ResponseEntity<ResultModel> linkSelect(HttpServletRequest request,HttpServletResponse response) {
		List list = dao.selectLink();
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
	//end
}
