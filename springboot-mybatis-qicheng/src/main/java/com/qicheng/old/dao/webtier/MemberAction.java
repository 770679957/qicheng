package com.qicheng.old.dao.webtier;

import com.qicheng.old.dao.MemberDao;

//会员管理Action
public class MemberAction {
	private int action;
	private MemberDao dao = null;
/*
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		dao = new MemberDao();
		this.action = Integer.parseInt(request.getParameter("action"));
		switch (action) {
		case 0: {
			return insertMember(mapping, form, request, response); // 添加员工信息
		}
		case 1: {
			return checkMember(mapping, form, request, response); // 会员登录
		}
		case 2: {
			return selectMember(mapping, form, request, response); // 查看会员信息
		}
		case 3: {
			return selectOneMember(mapping, form, request, response); // 查看会员的详细信息
		}
		case 4: {
			return deleteMember(mapping, form, request, response); // 删除会员信息
		}
		case 5: {
			return selectOneMemberHead(mapping, form, request, response); // 前台查询会员的属性
		}
		case 6: {
			return updateMemberHead(mapping, form, request, response); // 修改会员属性
		}

		}
		// MemberForm memberForm = (MemberForm) form;
		throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
	}

	// 修改会员属性
	public ActionForward updateMemberHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		Member member = (Member) form;
		dao.updateMember(member);
		request.setAttribute("success", "修改成功");
		return mapping.findForward("operationMember");
	}

	// 前台查询会员的属性
	public ActionForward selectOneMemberHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("form", dao.selectOneMember(Integer.valueOf(request.getParameter("id"))));
		return mapping.findForward("selectOneMemberHead");
	}

	// 删除操作
	public ActionForward deleteMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!dao.deleteMember(Integer.valueOf(request.getParameter("id")))) {
			return mapping.findForward("deleteMember");
		}
		return selectMember(mapping, form, request, response);
	}

	// 查看会员详细信息
	public ActionForward selectOneMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		request.setAttribute("form", dao.selectOneMember(id));
		return mapping.findForward("selectOneMember");
	}

	// 查看会员信息
	public ActionForward selectMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List list = dao.selectMember();
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
		request.setAttribute("number", String.valueOf(number));
		request.setAttribute("maxPage", String.valueOf(maxPage));
		request.setAttribute("pageNumber", String.valueOf(pageNumber));
		request.setAttribute("list", list);
		return mapping.findForward("selectMember");
	}

	// 会员登录
	public ActionForward checkMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("name");
		Member member = dao.selectMemberForm(name);
		if (member == null || member.equals("")) {
			request.setAttribute("result", "不存在此会员，请重新登录！！！");
		} else if (!member.getPassword().equals(request.getParameter("password").trim())) {
			request.setAttribute("result", "密码错误，请重新登录！！！");
		} else {
			request.setAttribute("memberForm", member);
		}
		return mapping.findForward("checkMember");
	}

	// 添加员工信息
	public ActionForward insertMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		Member member = (Member) form;
		Member formSelect = dao.selectMemberForm(member.getName());
		if (formSelect == null || formSelect.equals("")) {
			dao.insertMember(member);
			request.setAttribute("success", "注册成功");
		} else {
			request.setAttribute("success", "该会员名称已经存在！！！");
		}
		return mapping.findForward("operationMember");
	}
	*/
}
