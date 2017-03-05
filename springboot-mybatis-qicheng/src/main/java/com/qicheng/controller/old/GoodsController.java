package com.qicheng.controller.old;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qicheng.config.ResultStatus;
import com.qicheng.model.ResultModel;
import com.qicheng.old.dao.GoodsDao;
import com.qicheng.old.dao.SmallTypeDao;
import com.qicheng.old.model.Goods;
import com.qicheng.old.model.SmallType;

//商品的Action
@Controller
public class GoodsController {

	private GoodsDao dao = new GoodsDao();
	private SmallTypeDao smallDao = new SmallTypeDao();
	
	
	// 前台单独查询商品的信息 http://localhost:8080/goodSelectOneHead?id=1
	@RequestMapping("/goodSelectOneHead")
	@ResponseBody
	public ResponseEntity<ResultModel> goodSelectOneHead(Goods goods,Model model) {
		goods = dao.selectOneGoods(Integer.valueOf(goods.getId()));
		return new ResponseEntity<>(ResultModel.ok(goods), HttpStatus.OK);
	}
	
	// 特价商品
	// http://localhost:8080/goodSelectOneHead?mark=1&number=1
	@RequestMapping("/goodSelectFreeHead")
	@ResponseBody
	public ResponseEntity<ResultModel> goodSelectFreeHead(String mark,String number,Model model) {
		List list = null;
		list = dao.selectMark(Integer.valueOf(mark));
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
		if (maxPage % 4 == 0) {
			maxPage = maxPage / 4;
		} else {
			maxPage = maxPage / 4 + 1;
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
	
	// 新品查询
	//http://localhost:8080/goodSelectNewHead?mark=1
	@RequestMapping("/goodSelectNewHead")
	@ResponseBody
	public ResponseEntity<ResultModel> goodSelectNewHead(String mark,Model model) {
		List list = null;
		list = dao.selectMark(Integer.valueOf(mark));
		return new ResponseEntity<>(ResultModel.ok(list), HttpStatus.OK);
	}
	

	// 按小类别商品信息查询商品和商品小类别的名称
	// http://localhost:8080/goodSelectSmallHead?small=1&number=1&big=1
	@RequestMapping("/goodSelectSmallHead")
	@ResponseBody
	public ResponseEntity<ResultModel> goodSelectSmallHead(String small,String number,String big,Model model) {
		List list = null;
		list = dao.selectSmall(Integer.valueOf(small));
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
		if (maxPage % 4 == 0) {
			maxPage = maxPage / 4;
		} else {
			maxPage = maxPage / 4 + 1;
		}
		if (number == null) {
			number = "0";
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("number", String.valueOf(number));
		map.put("maxPage", String.valueOf(maxPage));
		map.put("pageNumber", String.valueOf(pageNumber));
		map.put("list", list);
		map.put("smallList", smallDao.selectOneBigId(Integer.valueOf(big)));
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}
	
	// 按大类别商品信息查询商品和商品小类别的名称
	//http://localhost:8080/goodSelectBigHead?big=1&number=1
	@RequestMapping("/goodSelectBigHead")
	@ResponseBody	
	public ResponseEntity<ResultModel> goodSelectBigHead(String big,String number,Model model) {
		List list = null;
		List smallList = null;
		list = dao.selectBig(Integer.valueOf(big));
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
		if (maxPage % 4 == 0) {
			maxPage = maxPage / 4;
		} else {
			maxPage = maxPage / 4 + 1;
		}
		if (number == null) {
			number = "0";
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("number", String.valueOf(number));
		map.put("maxPage", String.valueOf(maxPage));
		map.put("pageNumber", String.valueOf(pageNumber));
		map.put("list", list);
		map.put("smallList", smallDao.selectOneBigId(Integer.valueOf(big)));
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}
	
	// 设置特价价格
	//http://localhost:8080/managerFreePirce?mark=1&free=1&id=1
	@RequestMapping("/managerFreePirce")
	@ResponseBody	
	public ResponseEntity<ResultModel> managerFreePirce(String mark,String free,String id,Model model) {
		Goods goodsForm = new Goods();
		if (mark.equals("0")) {
			goodsForm.setFreePrice(Float.valueOf("0"));
			goodsForm.setMark(Integer.valueOf("0"));
			goodsForm.setId(Integer.valueOf(id));
			dao.managerPrice(goodsForm); //删除特价成功！！
			return new ResponseEntity<>(ResultModel.ok(ResultStatus.SUCCESS), HttpStatus.OK);
		} else {
			goodsForm.setFreePrice(Float.valueOf(free));
			goodsForm.setMark(Integer.valueOf(mark));
			goodsForm.setId(Integer.valueOf(id));
			dao.managerPrice(goodsForm); //设置特价成功！！
			return new ResponseEntity<>(ResultModel.ok(ResultStatus.SUCCESS), HttpStatus.OK);
		}
	}
	
	// 转向特价商品页面
	//http://localhost:8080/managerFreePirceForward?&id=1
	@RequestMapping("/managerFreePirceForward")
	@ResponseBody
	public ResponseEntity<ResultModel> managerFreePirceForward(String id,Model model) {
		return new ResponseEntity<>(ResultModel.ok(dao.selectOneGoods(Integer.valueOf(id))), HttpStatus.OK);
	}
	
	
	
	
	// 按大类别商品信息查询
	//http://localhost:8080/goodSelectBig?&big=1&number=1
	@RequestMapping("/goodSelectBig")
	@ResponseBody	
	public ResponseEntity<ResultModel> goodSelectBig(String big,String number,Model model) {
		List list = null;
		list = dao.selectBig(Integer.valueOf(big));
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
		map.put("number", String.valueOf(number));
		map.put("maxPage", String.valueOf(maxPage));
		map.put("pageNumber", String.valueOf(pageNumber));
		map.put("list", list);
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}
	
	// 按小类别商品信息查询
	//http://localhost:8080/goodSelectSmall?
	@RequestMapping("/goodSelectSmall")
	@ResponseBody	
	public ResponseEntity<ResultModel> goodSelectSmall(String small,String number,Model model) {
		List list = null;
		list = dao.selectSmall(Integer.valueOf(small));
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
		map.put("number", String.valueOf(number));
		map.put("maxPage", String.valueOf(maxPage));
		map.put("pageNumber", String.valueOf(pageNumber));
		map.put("list", list);
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}
	
	// 按特价商品信息查询
	//http://localhost:8080/goodSelectMark?number=1&mark=1
	@RequestMapping("/goodSelectMark")
	@ResponseBody
	public ResponseEntity<ResultModel> goodSelectMark(String number,String mark ,Model model) {
		List list = null;
		list = dao.selectMark(Integer.valueOf(mark));
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
		map.put("number", String.valueOf(number));
		map.put("maxPage", String.valueOf(maxPage));
		map.put("pageNumber", String.valueOf(pageNumber));
		map.put("list", list);
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}
	
	// 删除商品的操作
	// http://localhost:8080/deleteGoods?id=1
	@RequestMapping("/deleteGoods")
	@ResponseBody	
	public ResponseEntity<ResultModel> deleteGoods(String id,Model model) {
		dao.deleteGoods(Integer.valueOf(id)); //删除商品信息成功
		return new ResponseEntity<>(ResultModel.ok(ResultStatus.SUCCESS), HttpStatus.OK);
	}
	
	// 查看商品的详细信息
	//http://localhost:8080/selectOneGoods?id=1
	@RequestMapping("/selectOneGoods")
	@ResponseBody	
	public ResponseEntity<ResultModel> selectOneGoods(String id,Model model) {
		return new ResponseEntity<>(ResultModel.ok(dao.selectOneGoods(Integer.valueOf(id))), HttpStatus.OK);
	}
	
	/**
	// 添加商品的信息
	 *  Springboot 之 多文件上传 http://blog.csdn.net/zsl129/article/details/53020180
	 * http://blog.csdn.net/zsl129/article/details/52906762?locationNum=11&fps=1
	 * 
	//http://localhost:8080/saveGoods?
	@RequestMapping("/saveGoods")
	@ResponseBody	
	public ResponseEntity<ResultModel> saveGoods(Model model,HttpServletRequest request) {
	public ActionForward saveGoods(ActionMapping mapping, ActionForm form, ,
			HttpServletResponse response) throws Exception {
		UploadFile uploadFile = new UploadFile();
		GoodsForm goodsForm = (GoodsForm) form;

		String dir = servlet.getServletContext().getRealPath("/goodsPicture");
		FormFile formFile = goodsForm.getFormFile();
		String getType = formFile.getFileName().substring(formFile.getFileName().lastIndexOf(".") + 1);
		String result = "添加商品信息失败";
		String imageType[] = { "JPG", "jpg", "gif", "bmp", "BMP" };
		for (int ii = 0; ii < imageType.length; ii++) {
			if (imageType[ii].equals(getType)) {

				goodsForm.setBig(Integer.valueOf(request.getParameter("big")));
				goodsForm.setSmall(Integer.valueOf(request.getParameter("small")));
				goodsForm.setName(request.getParameter("name"));
				goodsForm.setFrom(request.getParameter("from"));
				goodsForm.setNowPrice(Float.valueOf(request.getParameter("nowPirce")));
				goodsForm.setFreePrice(Float.valueOf(request.getParameter("freePirce")));
				goodsForm.setIntroduce(request.getParameter("introduce"));

				goodsForm.setPriture("goodsPicture/" + uploadFile.upload(dir, formFile));
				dao.insertGoods(goodsForm);
				result = "添加商品信息成功";
			}
		}
		request.setAttribute("result", result);
		return mapping.findForward("goodsOperation");
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}
	
	
	// 查询小类别的名称
	//http://localhost:8080/selectSmallName?
	@RequestMapping("/selectSmallName")
	@ResponseBody	
	public ResponseEntity<ResultModel> selectSmallName(,Model model) {
	public ActionForward selectSmallName(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("bigId", request.getParameter("bigId"));
		return mapping.findForward("goodForward");
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}

	// 转向页面
	//http://localhost:8080/?
	@RequestMapping("/goodSelectNewHead")
	@ResponseBody	
	public ResponseEntity<ResultModel> (,Model model) {
	public ActionForward goodForward(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return mapping.findForward("goodForward");
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}
*/
	// 全部查询信息
	//http://localhost:8080/goodSelect?
	@RequestMapping("/goodSelect")
	@ResponseBody
	public ResponseEntity<ResultModel> goodSelect(String number,Model model) {
		List list = null;
		list = dao.selectGoods();
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
		map.put("number", String.valueOf(number));
		map.put("maxPage", String.valueOf(maxPage));
		map.put("pageNumber", String.valueOf(pageNumber));
		map.put("list", list);
		return new ResponseEntity<>(ResultModel.ok(map), HttpStatus.OK);
	}
	
	
	
	
	
	
}
