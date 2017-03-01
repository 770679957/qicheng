package com.qicheng.old.dao.webtier;

import com.qicheng.old.dao.BigTypeDao;

//商品大类别信息
public class BigTypeAction{

	private int action;
	private BigTypeDao dao = null;
/*
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		dao = new BigTypeDao();
		this.action = Integer.parseInt(request.getParameter("action"));
		switch (action) {
		case 0: {
			return bigTypeSelect(mapping, form, request, response); // 全部查询商品信息
		}
		case 2: {
			return bigTypeInsert(mapping, form, request, response); // 添加大类别的信息
		}
		case 3: {
			return bigTypeDelete(mapping, form, request, response); // 删除大类别的信息
		}
		}

		throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
	}

	// 删除大类别的信息
	public ActionForward bigTypeDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		if (dao.deleteBig(Integer.valueOf(request.getParameter("id")))) {
			request.setAttribute("result", "删除大类别信息成功");
		} else {
			request.setAttribute("result", "小类别还存在此信息，请先删除小类别信息");
		}

		return mapping.findForward("resultBigType");
	}

	// 添加大类别的信息
	public ActionForward bigTypeInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		dao.insertBig(request.getParameter("name"));
		request.setAttribute("result", "添加大类别信息成功");
		return mapping.findForward("resultBigType");
	}

	// 全部查询商品信息
	public ActionForward bigTypeSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List list = dao.selectBig();
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
		return mapping.findForward("bigTypeSelect");
	}
*/
}
