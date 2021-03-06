package com.qicheng.old.dao.webtier;

import com.qicheng.old.dao.SmallTypeDao;

//商品小类别信息
public class SmallTypeAction {
	private int action;
	private SmallTypeDao dao = null;
/*
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		action = Integer.parseInt(request.getParameter("action"));
		dao = new SmallTypeDao();
		switch (action) {
		case 0: {
			return smallTypeSelect(mapping, form, request, response); // 全部查询小类别信息
		}
		case 2: {
			return smallTypeInsert(mapping, form, request, response); // 添加小类别信息
		}
		case 3: {
			return smallTypeDelete(mapping, form, request, response); // 删除小类别信息
		}
		case 4: {
			return smallTypeSelectOne(mapping, form, request, response); // 以数据库流水号为条件查询小类别信息
		}
		case 5: {
			return smallTypeUpdate(mapping, form, request, response); // 以数据库流水号为条件修改小类别信息
		}
		case 6: {
			return smallTypeSelectBigId(mapping, form, request, response); // 以外键编号为条件修改小类别信息
		}
		}

		throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
	}

	// 以外键编号为条件修改小类别信息
	public ActionForward smallTypeSelectBigId(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List list = dao.selectOneBigId(Integer.valueOf(request.getParameter("bigId")));
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
		return mapping.findForward("smallTypeSelect");
	}

	// 以数据库流水号为条件修改小类别信息
	public ActionForward smallTypeUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		SmallTypeForm smallTypeForm = (SmallTypeForm) form;
		smallTypeForm.setBigId(Integer.valueOf(request.getParameter("bigId")));
		smallTypeForm.setId(Integer.valueOf(request.getParameter("id")));
		smallTypeForm.setSmallName(request.getParameter("name"));
		dao.updateSmall(smallTypeForm);
		request.setAttribute("success", "修改小类别信息成功");
		return mapping.findForward("smallTypeOperation");
	}

	// 以数据库流水号为条件查询小类别信息
	public ActionForward smallTypeSelectOne(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("small", dao.selectOneBig(Integer.valueOf(request.getParameter("id"))));
		return mapping.findForward("smallTypeSelectOne");
	}

	// 删除小类别信息
	public ActionForward smallTypeDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		if (dao.deleteSmall(Integer.valueOf(request.getParameter("id")))) {
			request.setAttribute("result", "删除小类别信息成功！");
		} else {
			request.setAttribute("result", "商品信息还存在此类别，请先删除商品信息！！！");
		}
		return mapping.findForward("smallTypeOperation");
	}

	// 添加小类别信息
	public ActionForward smallTypeInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		SmallTypeForm smallTypeForm = (SmallTypeForm) form;
		smallTypeForm.setBigId(Integer.valueOf(request.getParameter("bigId")));
		smallTypeForm.setSmallName(request.getParameter("name"));
		dao.insertSmall(smallTypeForm);
		request.setAttribute("result", "添加小类别信息成功");
		return mapping.findForward("smallTypeOperation");
	}

	// 全部查询小类别信息
	public ActionForward smallTypeSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List list = dao.selectSmall();
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
		return mapping.findForward("smallTypeSelect");
	}
	*/
}
