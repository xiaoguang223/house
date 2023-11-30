package com.house_springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house_springboot.Pojo.Hetong;
import com.house_springboot.Pojo.User;
import com.house_springboot.Pojo.Userlist;
import com.house_springboot.Pojo.Zulist;
import com.house_springboot.VO.zuVO;
import com.house_springboot.service.UserlistService;
import com.house_springboot.service.ZulistService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/zulist")
public class ZulistController {
	@Autowired
	private ZulistService zulistService;

	@ApiOperation("在租列表")
	@GetMapping("/getzulist")
	public List<zuVO> getzuList(String name){
		if(name!=null){
			List<zuVO> zuVOS = zulistService.findzuList(name);
			return zuVOS;
		}
		List<zuVO> zuVOS = zulistService.findzuList2();
		return zuVOS;
	}
	//跳到增添合同的页面
//	@RequestMapping("/toaddhetong")
//	public String toaddhetong(Model model,String house_id){
//		Hetong hetong=new Hetong();
//		hetong.setHouse_id(house_id);
//		model.addAttribute("hetong", hetong);
//		model.addAttribute("mainPage", "addhetong.jsp");
//
//		return "admin/main1";
//	}
//	//管理员查看所有在租列表
//	@RequestMapping("/findzulist")
//	public String findzulist(Model model,@RequestParam(required=false,defaultValue="1") Integer page,
//            @RequestParam(required=false,defaultValue="2") Integer pageSize) throws Exception{
//		PageHelper.startPage(page, pageSize);
//		List<Zulist> zulist=zulistService.findzuuserlist();
//		PageInfo<Zulist> p=new PageInfo<Zulist>(zulist);
//		model.addAttribute("p", p);
//		model.addAttribute("zulist", zulist);
//		model.addAttribute("mainPage", "zulist.jsp");
//		return "admin/main1";
//	}
//
//	//查看我的在租列表
//	@RequestMapping("/myzulist")
//	public String myzulist(Model model,HttpSession httpSession,@RequestParam(required=false,defaultValue="1") Integer page,
//            @RequestParam(required=false,defaultValue="2") Integer pageSize) throws Exception{
//
//		User user1= (User) httpSession.getAttribute("user");
//		Userlist userlist=userlistService.findhasuserlist(user1.getId());
//		PageHelper.startPage(page, pageSize);
//		List<Userlist> list=userlistService.getUserzuList(userlist.getId());
//		PageInfo<Userlist> p=new PageInfo<Userlist>(list);
//		model.addAttribute("userlistzu", list);
//		model.addAttribute("p", p);
//		model.addAttribute("mainPage", "myzulist.jsp");
//
//		return "zuke/main";
//	}
	
}
