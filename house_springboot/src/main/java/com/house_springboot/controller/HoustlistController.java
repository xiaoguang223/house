package com.house_springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house_springboot.Pojo.Houselist;
import com.house_springboot.VO.HostVO;
import com.house_springboot.service.HouselistService;
import com.house_springboot.utils.ConvertUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HoustlistController {
	@Autowired
	private HouselistService houselistService;
	
//	@GetMapping("/houselist")
//	public String houselist(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
//            @RequestParam(required=false,defaultValue="2") Integer pageSize){
//
//		 PageHelper.startPage(page, pageSize);
//		List<Houselist> houselist=houselistService.selectAll();
//	PageInfo<Houselist> p=new PageInfo<Houselist>(houselist);
//
//
//		model.addAttribute("p", p);
//		model.addAttribute("houselist",houselist);
//		model.addAttribute("mainPage","houselist.jsp");
//		return "zuke/main";
//	}
//


	@ApiOperation("房源信息")
	@GetMapping("/ahouselist")
	public List<HostVO> houseList(String name){
		LambdaQueryWrapper<Houselist> queryWrapper = new LambdaQueryWrapper<>();
		if(name!=null){
			queryWrapper.eq(Houselist::getAddress,name);
			Houselist houselists = houselistService.selectByAddress(name);
			HostVO hostVO = ConvertUtil.sourceToTarget(houselists, HostVO.class);
			List<HostVO> hostVOS=new ArrayList<>();
			hostVOS.add(hostVO);
			return hostVOS;
		}else{
			List<Houselist> houselists = houselistService.selectAll();
			List<HostVO> hostVOS = ConvertUtil.sourceToTarget(houselists, HostVO.class);
			return hostVOS;
		}
	}
	
//	@RequestMapping("/addhouse")
//	public String addhouse(Model model ,Houselist houselist){
//
//		String houseid=houselist.getHouseid();
//		Houselist houselist1=houselistService.findhouseid(houseid);
//		if(houselist1!=null){
//			model.addAttribute("error","该房屋id已存在");
//			model.addAttribute("houselist",houselist);
//			model.addAttribute("mainPage","addhouse.jsp");
//			return "admin/main1";
//		}else{
//			model.addAttribute("error","添加成功");
//			houselistService.inserthouse(houselist);
//			model.addAttribute("houselist",houselist);
//			model.addAttribute("mainPage","addhouse.jsp");
//		return "admin/main1";
//	}
//		}
//
//	@RequestMapping("/toaddhouse")
//	public String toaddhoust(Model model){
//		model.addAttribute("mainPage","addhouse.jsp");
//
//		return "admin/main1";
//	}
//	@RequestMapping("/deletehouse")
//	public String deletehouse(Integer id){
//		houselistService.deletehouse(id);
//
//
//		return "redirect:ahouselist.action";
//	}
//	@RequestMapping("/toahouselist")
//	public String toahouselist(){
//
//
//
//		return "ahouselist.action";
//	}
//	@RequestMapping("/findid")
//	public String findid(Integer id,Model model){
//		Houselist list=houselistService.findid(id);
//		model.addAttribute("houselist",list);
//		model.addAttribute("mainPage", "changehouse.jsp");
//		return "admin/main1";
//	}
//	@RequestMapping("/findhouseidupdate")
//	public String findhouseidupdate(Houselist houselist,Model model){
//		Houselist list=houselistService.findhouseidupdate(houselist);
//		if(list!=null){
//			model.addAttribute("houselist",houselist);
//			model.addAttribute("mainPage", "changehouse.jsp");
//			model.addAttribute("error","该房屋id已存在");
//			return "admin/main1";
//		}
//		else{
//			houselistService.updatehouse(houselist);
//			model.addAttribute("houselist",houselist);
//			model.addAttribute("mainPage", "changehouse.jsp");
//			model.addAttribute("error","更新成功");
//			return "admin/main1";
//		}
//	}
	
}
