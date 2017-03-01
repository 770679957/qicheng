package com.qicheng.old.dao.webtier;

import javax.servlet.http.HttpSession;

import com.qicheng.old.dao.ManagerDao;

//后台管理员的Action
public class ManagerAction {
	private ManagerDao dao = null;
	private int action;
	private HttpSession session = null;
/*
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		dao = new ManagerDao();
		action = Integer.parseInt(request.getParameter("action"));
		switch (action) {
		case 0: {
			return managerCheck(mapping, form, request, response); // 判断管理员登录后台
		}
		case 1: {
			return managerSelect(mapping, form, request, response); // 查询所有的管理员信息
		}
		case 3: {
			return managerInsert(mapping, form, request, response); // 添加管理员信息
		}
		case 4: {
			return managerDelete(mapping, form, request, response); // 删除管理员信息
		}
		case 8: {
			return managerUpdatePassword(mapping, form, request, response); // 转向修改密码的页面
		}
		}
		throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
	}

	// 修改管理员密码
	public ActionForward managerUpdatePassword(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ManagerForm managerForm = (ManagerForm) form;
		managerForm.setAccount(request.getParameter("account"));
		managerForm.setPassword(request.getParameter("password"));
		dao.updateManagerPassword(managerForm);
		request.setAttribute("reslut", "修改后台管理员密码成功，请重新登录！！！");
		return mapping.findForward("managerUpdatePassword");
	}

	// 删除管理员信息
	public ActionForward managerDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		dao.deleteManager(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("reslut", "删除此用户名成功！！！");
		return managerSelect(mapping, form, request, response);
	}

	// 添加管理员信息
	public ActionForward managerInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ManagerForm managerForm = (ManagerForm) form;

		ManagerForm manager = dao.selectOne(managerForm.getAccount());
		if (manager == null || manager.equals("")) {
			dao.insertManager(managerForm);
			return managerSelect(mapping, form, request, response);
		} else {
			request.setAttribute("reslut", "此用户名已经存在！！！");
			return mapping.findForward("managerInsert");
		}
	}

	// 查询所有的管理员信息
	public ActionForward managerSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List list = dao.selectManager();
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
		String number = request.getParameter("i");
		if (maxPage % 7 == 0) {
			maxPage = maxPage / 7;
		} else {
			maxPage = maxPage / 7 + 1;
		}
		if (number == null) {
			number = "0";
		}
		request.setAttribute("number", String.valueOf(number));
		request.setAttribute("maxPage", String.valueOf(maxPage));
		request.setAttribute("pageNumber", String.valueOf(pageNumber));

		request.setAttribute("list", list);
		return mapping.findForward("managerSelect");
	}

	// 判断管理员登录后台
	public ActionForward managerCheck(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String account = request.getParameter("account");
		ManagerForm managerForm = dao.selectOne(account);
		if (managerForm == null) {
			request.setAttribute("result", "您输入的账号不存在！！！");
			return mapping.findForward("checkResult");
		} else if (!managerForm.getPassword().equals(request.getParameter("password"))) {
			request.setAttribute("result", "您输入的密码不存在！！！");
			return mapping.findForward("checkResult");
		} else {
			request.setAttribute("manager", managerForm);
			return mapping.findForward("checkResult");
		}
	}
	*/
}
