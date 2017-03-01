package com.qicheng.controller.old;

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
	private MemberDao dao;
	
	
	// http://localhost:8080/insertMember?age=25&email=123456@qq.com&name=杨杨&password=1234356&profession=职业&question=问个问题&reallyName=真实姓名&result=答案	
	// 添加员工信息
	@RequestMapping("/insertMember")
	@ResponseBody
	public ResponseEntity<ResultModel> insertMember(Member member,Model model) {
		dao = new MemberDao();
		Member formSelect = dao.selectMemberForm(member.getName());
		if (formSelect == null || formSelect.equals("")) {
			dao.insertMember(member);
			return new ResponseEntity<>(ResultModel.ok(ResultStatus.REGISTER_SUCCESS), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultModel.error(ResultStatus.USER_YES_FOUND), HttpStatus.ACCEPTED);
		}
		
	}
	
	// http://localhost:8080/updateMember?id=4&age=25&email=123456@qq.com&name=杨杨2&password=1234356&profession=职业&question=问个问题&reallyName=真实姓名&result=答案
	// 修改会员属性
	@RequestMapping("/updateMember")
	@ResponseBody
	public ResponseEntity<ResultModel> updateMemberHead(Member member,Model model) {
		dao = new MemberDao();
		dao.updateMember(member);
		return new ResponseEntity<>(ResultModel.ok(ResultStatus.UPDATE_SUCCESS), HttpStatus.OK);
	}
 
	
	
	
	
	
	
	
	
	
	// ==JDBC_End==============================================================================
	
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
}
