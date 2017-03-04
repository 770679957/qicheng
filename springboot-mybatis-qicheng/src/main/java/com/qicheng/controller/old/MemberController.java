package com.qicheng.controller.old;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qicheng.config.ResultStatus;
import com.qicheng.model.ResultModel;
import com.qicheng.old.dao.MemberDao;
import com.qicheng.old.model.Member;

/**会员管理Action*/
@Controller
public class MemberController {
	
	//  http://localhost:8080/test?name=yyw
	//  http://localhost:8080/test
	
	
	// ==JDBC_Start==============================================================================
	private MemberDao dao = new MemberDao();;
	
	// http://localhost:8080/updateMember?id=4&age=25&email=123456@qq.com&name=杨杨2&password=1234356&profession=职业&question=问个问题&reallyName=真实姓名&result=答案
	// 修改会员属性
	@RequestMapping("/updateMember")
	@ResponseBody
	public ResponseEntity<ResultModel> updateMemberHead(Member member,Model model) {
		dao.updateMember(member);
		return new ResponseEntity<>(ResultModel.ok(ResultStatus.UPDATE_SUCCESS), HttpStatus.OK);
	}
	
	// http://localhost:8080/selectOneMemberHead?id=5
	// 前台查询会员的属性 app使用
	@RequestMapping("/selectOneMemberHead")
	@ResponseBody
	public ResponseEntity<ResultModel> selectOneMemberHead(Member member,Model model) {
		member = dao.selectOneMember(Integer.valueOf(member.getId()));
		return new ResponseEntity<>(ResultModel.ok(member), HttpStatus.OK);
	}
 
	// http://localhost:8080/selectOneMemberHead2?id=4
	// 前台查询会员的属性 web使用
	@RequestMapping("/selectOneMemberHead2")
	@ResponseBody //web 页面不要此注解 return "-----";
	public Member selectOneMemberHead2(Member member,Model model) {
		member = dao.selectOneMember(Integer.valueOf(member.getId()));
		return member;
	}
	
	// http://localhost:8080/deleteMember?id=4
	// 删除操作
	@RequestMapping("/deleteMember")
	@ResponseBody
	public ResponseEntity<ResultModel> deleteMember(Member member,Model model) {
		if (!dao.deleteMember(Integer.valueOf(member.getId()))) {
			return new ResponseEntity<>(ResultModel.ok(ResultStatus.DELETE_SUCCESS), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResultModel.ok(ResultStatus.FAIL), HttpStatus.OK);
	}
	
	// http://localhost:8080/selectOneMember?id=5
	// 查看会员详细信息
	@RequestMapping("/selectOneMember")
	@ResponseBody
	public ResponseEntity<ResultModel> selectOneMember(Member member,Model model) {
		Integer id = Integer.valueOf(member.getId());
		member = dao.selectOneMember(id);
		return new ResponseEntity<>(ResultModel.ok(member), HttpStatus.OK);
	}
	
	// 查看会员信息 http://localhost:8080/selectMember?number=3
	/**
	 * 
	 * @param number 每页条数
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectMember")
	@ResponseBody
	public ResponseEntity<ResultModel> selectMember(String number,Model model) {
		List list = dao.selectMember();
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
		if (maxPage % 6 == 0) {
			maxPage = maxPage / 6;
		} else {
			maxPage = maxPage / 6 + 1;
		}
		if (number == null) {
			number = "0";
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("number",  String.valueOf(number));
		map.put("maxPage",  String.valueOf(maxPage));
		map.put("pageNumber",  String.valueOf(pageNumber));
		map.put("list", list);
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}
	
	// 会员登录 http://localhost:8080/checkMember?name=杨杨&password=1234356
	// 会员登录 http://localhost:8080/checkMember?name=杨杨x&password=1234356
	// 会员登录 http://localhost:8080/checkMember?name=杨杨&password=1234356x
	@RequestMapping("/checkMember")
	@ResponseBody
	public ResponseEntity<ResultModel> checkMember(Member member,Model model) {
		String name = member.getName();
		Member memberDb = dao.selectMemberForm(name);
		if (memberDb == null || memberDb.equals("")) {
			return new ResponseEntity<>(ResultModel.error(ResultStatus.USER_NOT_FOUND), HttpStatus.OK);
		} else if (!memberDb.getPassword().equals(member.getPassword().trim())) {
			return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResultModel.ok(memberDb), HttpStatus.OK);
	}
		
	
	
	// http://localhost:8080/insertMember?age=25&email=123456@qq.com&name=杨杨67&password=1234356&profession=职业&question=问个问题&reallyName=真实姓名&result=答案	
	// 添加员工信息
	@RequestMapping("/insertMember")
	@ResponseBody
	public ResponseEntity<ResultModel> insertMember(Member member,Model model) {
		Member formSelect = dao.selectMemberForm(member.getName());
		if (formSelect == null || formSelect.equals("")) {
			dao.insertMember(member);
			return new ResponseEntity<>(ResultModel.ok(ResultStatus.REGISTER_SUCCESS), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultModel.error(ResultStatus.USER_YES_FOUND), HttpStatus.ACCEPTED);
		}
	}
	
	// ==JDBC_End==============================================================================

	
	
	// ==MyBatis_Start=========================================================================
    @RequestMapping("/test")
    @ResponseBody
    public Member greeting(@RequestParam(value="action", required=false, defaultValue="0") String action, Model model) {
        model.addAttribute("action", action);
        System.out.println("yyw========="+model.toString());
        return new Member();
    }
    
    @RequestMapping("/test2")
    public String greeting2(@RequestParam(value="name", required=false, defaultValue="World!") String name, Model model) {
    	model.addAttribute("name", name);
    	System.out.println("yyw========="+model.toString());
    	
    	return "";
    }
 // ==MyBatis_End============================================================================
}
