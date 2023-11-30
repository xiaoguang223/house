package com.house_springboot.service;


import com.house_springboot.Pojo.Paid;
import com.house_springboot.Pojo.QueryVo;
import com.house_springboot.Pojo.Zulist;

import java.util.List;

public interface PaidService {
	public List<Paid> selectall(QueryVo vo);
	public Double selectsum(QueryVo vo);
	public void deletepaid(Integer id);
	public List<Zulist> findzuuserlist() throws Exception;
	public Zulist findzukezulist(Integer id);
	
}
