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
	private MemberDao dao = new MemberDao();;
	
	
	// http://localhost:8080/insertMember?age=25&email=123456@qq.com&name=杨杨&password=1234356&profession=职业&question=问个问题&reallyName=真实姓名&result=答案	
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
	
	// http://localhost:8080/updateMember?id=4&age=25&email=123456@qq.com&name=杨杨2&password=1234356&profession=职业&question=问个问题&reallyName=真实姓名&result=答案
	// 修改会员属性
	@RequestMapping("/updateMember")
	@ResponseBody
	public ResponseEntity<ResultModel> updateMemberHead(Member member,Model model) {
		dao.updateMember(member);
		return new ResponseEntity<>(ResultModel.ok(ResultStatus.UPDATE_SUCCESS), HttpStatus.OK);
	}
	
	// http://localhost:8080/selectOneMemberHead?id=4
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
		return new ResponseEntity<>(ResultModel.ok(ResultStatus.DELETE_SUCCESS), HttpStatus.OK);
	}
	
	
	/*
 
	// 删除操作
	public ActionForward deleteMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!dao.deleteMember(Integer.valueOf(request.getParameter("id")))) {
			return mapping.findForward("deleteMember");
		}
		return selectMember(mapping, form, request, response);
	}
	 
	 
	 */
	
	
	
	
	
	
	
	
	
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
