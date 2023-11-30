package com.house_springboot.service;


import com.house_springboot.Pojo.Paid;
import com.house_springboot.Pojo.QueryVo;
import com.house_springboot.Pojo.Topaid;

import java.util.List;

public interface TopaidService {
	public void inserttopaid(Topaid topaid);
	public List<Topaid> findtopaid(QueryVo vo);
	public Topaid findbyid(Integer id);
	public void gotopay(Integer id, Paid paid);
}
