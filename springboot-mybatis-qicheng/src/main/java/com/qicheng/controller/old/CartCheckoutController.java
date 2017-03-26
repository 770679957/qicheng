package com.qicheng.controller.old;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qicheng.config.ResultStatus;
import com.qicheng.form.CartCheckoutForm;
import com.qicheng.model.ResultModel;
import com.qicheng.old.dao.GoodsDao;
import com.qicheng.old.dao.MemberDao;
import com.qicheng.old.dao.OrderDao;
import com.qicheng.old.dao.OrderDetailDao;
import com.qicheng.old.dao.RebateDao;
import com.qicheng.old.model.Goods;
import com.qicheng.old.model.Member;
import com.qicheng.old.model.Order;
import com.qicheng.old.model.OrderDetail;
import com.qicheng.old.model.Rebate;

//收银台
@Controller
public class CartCheckoutController {
	private MemberDao memberDao = new MemberDao();
	private RebateDao rebateDao = new RebateDao();
	private OrderDetailDao orderDetailDao = new OrderDetailDao();
	private GoodsDao goodsDao = new GoodsDao();
	private OrderDao orderDao = new OrderDao();
	
	@RequestMapping("/onSubmit")
	@ResponseBody
	protected ResponseEntity<ResultModel> onSubmit(CartCheckoutForm form,Model model,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Member user = memberDao.selectMemberForm(form.getUsername());
		if (user == null) {
			session.invalidate();
			return new ResponseEntity<>(ResultModel.ok(ResultStatus.USER_NOT_LOGIN), HttpStatus.OK);
		}
		Rebate rebateForm = rebateDao.selectOneRebate(Integer.valueOf(user.getGrade()));
		float rebate = rebateForm.getRebate();
		List<Goods> cart = (List<Goods>) session.getAttribute("cart");
		int number = 0;
		double nowprice = (float) 0.0;
		double sum = (float) 0;
		double Totalsum = (float) 0;
		long ID = -1;
		// 插入订单主表数据
		short bnumber = 0;
		if (cart != null) {
			bnumber = (short) cart.size();
		}
		Order order = new Order();
/*		order.setAddress(form.getAddress());
		order.setBnumber(bnumber);
		order.setBz(form.getBz());
		order.setCarry(form.getCarry());
		order.setPay(form.getPay());
		order.setPostcode(form.getPostcode());
		order.setRebate(rebate);
		order.setTel(form.getTel());
		order.setTruename(form.getTruename());
		order.setUsername(form.getUsername());
		order.setOrderDate(new Date());
		order.setEnforce(0);*/
		
		Set<OrderDetail> tbOrderDetails = null;
		// 插入订单明细表数据
		for (int i = 0; i < bnumber; i++) {
			Goods myGoodsElement = cart.get(i);
			ID = myGoodsElement.getId();
			nowprice = myGoodsElement.getNowPrice() * rebate;
			number = myGoodsElement.getNumber();
			sum = nowprice * number;
			OrderDetail details = new OrderDetail();
			details.setNumber(number);
			details.setPrice((float) nowprice);
			//details.setTbOrder(order);
			details.setGoodsId(order.getId());
			Goods goods = goodsDao.selectOneGoods((int) ID);
			details.setGoodsId(goods.getBig());
			tbOrderDetails.add(details);
			Totalsum = Totalsum + sum;
		}
		// 更新会员信息和会员等级
		user.setAmount(user.getAmount() == null ? Totalsum : user.getAmount() + Totalsum);
		int userGrade = rebateDao.getGrade(user.getAmount());
		if (user.getGrade() == null || userGrade > Integer.valueOf(user.getGrade())){
			user.setGrade(String.valueOf(userGrade) );
		}
		
		//memberDao.insertObject(user, order);// 在事物中完成订单保存和会员的更新
		memberDao.insertMember(user);
		Long id =  orderDao.insertOrder(order);
		order.setId(Integer.valueOf(id.toString()));
		session.removeAttribute("cart");
		return new ResponseEntity<>(ResultModel.ok(order), HttpStatus.OK);
		// return new ModelAndView(new RedirectView("cartSee.lzw?orderId=" + order.getOrderId()));
	}

}
