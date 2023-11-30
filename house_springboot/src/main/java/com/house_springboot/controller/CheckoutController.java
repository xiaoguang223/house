package com.house_springboot.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house_springboot.Pojo.Checkout;
import com.house_springboot.Pojo.User;
import com.house_springboot.Pojo.Userlist;
import com.house_springboot.VO.CheckoutVO;
import com.house_springboot.service.CheckoutService;
import com.house_springboot.service.UserlistService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/checkout")
public class CheckoutController {
	@Autowired
	private CheckoutService checkoutService;
	@Autowired
	private UserlistService userlistService;

	@ApiOperation("房屋退租")
	@GetMapping("/getCheckout")
	public List<CheckoutVO> getCheckoutVO(String name){
		if(name!=null){
			CheckoutVO selectone = checkoutService.selectone(name);
			List<CheckoutVO> checkoutVOS=new ArrayList<>();
			checkoutVOS.add(selectone);
			return checkoutVOS;
		}
		List<CheckoutVO> selectall = checkoutService.selectall();
		return selectall;
	}
	
//	@RequestMapping("/getallcheckout")
//	public String getallcheckout(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
//            @RequestParam(required=false,defaultValue="2") Integer pageSize){
//		 PageHelper.startPage(page, pageSize);
//		List<Checkout> checkout=checkoutService.getallcheckout();
//		PageInfo<Checkout> p=new PageInfo<Checkout>(checkout);
//		model.addAttribute("p", p);
//		model.addAttribute("checkout", checkout);
//		model.addAttribute("mainPage", "checkout.jsp");
//		return "admin/main1";
//	}
//	//租客删除自己已退租列表
//	@RequestMapping("/deletecheckout")
//	public String deletecheckout(Integer id ) {
//		checkoutService.deletecheckout(id);
//		return "redirect:/checkout/getmycheckout.action";
//	}
//	//租客删除自己已退租列表
//		@RequestMapping("/admindeletecheckout")
//		public String admindeletecheckout(Integer id ) {
//			checkoutService.deletecheckout(id);
//			return "redirect:/checkout/getallcheckout.action";
//		}
//
//	@RequestMapping("/getmycheckout")
//	public String getmycheckout(Model model,HttpSession httpSession,@RequestParam(required=false,defaultValue="1") Integer page,
//            @RequestParam(required=false,defaultValue="2") Integer pageSize) {
//		User user1= (User) httpSession.getAttribute("user");
//		Userlist userlist=userlistService.findhasuserlist(user1.getId());
//		PageHelper.startPage(page, pageSize);
//		List<Userlist> list=userlistService.getmycheckout(userlist.getId());
//		PageInfo<Userlist> p=new PageInfo<Userlist>(list);
//		model.addAttribute("p", p);
//		model.addAttribute("userlistcheck", list);
//		model.addAttribute("mainPage","mycheckout.jsp");
//		return "zuke/main";
//	}
}
