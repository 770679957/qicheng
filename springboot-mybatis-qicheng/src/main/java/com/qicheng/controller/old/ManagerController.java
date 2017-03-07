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
import com.qicheng.old.dao.ManagerDao;
import com.qicheng.old.model.Manager;

//后台管理员的Action
@Controller
public class ManagerController {
	
	private ManagerDao dao = new ManagerDao();
	
	// 修改管理员密码 http://localhost:8080/managerUpdatePassword?account=1&password=1
	@RequestMapping("/managerUpdatePassword")
	@ResponseBody
	public ResponseEntity<ResultModel> managerUpdatePassword(HttpServletRequest request, HttpServletResponse response) {
		Manager managerForm = new Manager();
		managerForm.setAccount(request.getParameter("account"));
		managerForm.setPassword(request.getParameter("password"));
		dao.updateManagerPassword(managerForm);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK); //修改后台管理员密码成功，请重新登录！！！
	}
	
	// 删除管理员信息 http://localhost:8080/managerDelete?id=1
	@RequestMapping("/managerDelete")
	@ResponseBody
	public ResponseEntity<ResultModel> managerDelete(HttpServletRequest request, HttpServletResponse response) {
		dao.deleteManager(Integer.valueOf(request.getParameter("id")));
		return new ResponseEntity<>(ResultModel.ok(ResultStatus.DELETE_SUCCESS), HttpStatus.OK); //删除此用户名成功！！！
	}
	
	// 添加管理员信息 http://localhost:8080/managerInsert?account=3&password=1&name=1&sign=1
	@RequestMapping("/managerInsert")
	@ResponseBody
	public ResponseEntity<ResultModel> managerInsert(Manager managerForm,HttpServletRequest request, HttpServletResponse response) {
		Manager manager = dao.selectOne(managerForm.getAccount());
		if (manager == null || manager.equals("")) {
			dao.insertManager(managerForm);
			return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultModel.error(ResultStatus.USER_YES_FOUND), HttpStatus.OK); //此用户名已经存在！！！
		}
	}
	
	// 查询所有的管理员信息 http://localhost:8080/managerSelect?number=1
	@RequestMapping("/managerSelect")
	@ResponseBody
	public ResponseEntity<ResultModel> managerSelect(HttpServletRequest request, HttpServletResponse response) {
		List list = dao.selectManager();
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
	
	// 判断管理员登录后台 http://localhost:8080/managerCheck?account=1
	@RequestMapping("/managerCheck")
	@ResponseBody
	public ResponseEntity<ResultModel> managerCheck(HttpServletRequest request, HttpServletResponse response) {
		String account = request.getParameter("account");
		Manager managerForm = dao.selectOne(account);
		if (managerForm == null) {
			return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.OK); //您输入的账号不存在！！！
		} else if (!managerForm.getPassword().equals(request.getParameter("password"))) {
			return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.OK); //您输入的密码不存在！！！
		} else {
			return new ResponseEntity<>(ResultModel.ok(managerForm), HttpStatus.OK);
		}
	}
//end
}

