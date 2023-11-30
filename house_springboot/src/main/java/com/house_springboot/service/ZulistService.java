package com.house_springboot.service;


import com.house_springboot.Pojo.Zulist;
import com.house_springboot.VO.zuVO;

import java.util.List;

public interface ZulistService {
	public void insertzulist(Zulist zulist);
	public List<Zulist> findzuuserlist() throws Exception;
	public Zulist findzulist(String house_id);
	public void deletezulist(String house_id);
	public List<Zulist> findzulistbyuid(Integer userlist_id);

	public List<zuVO> findzuList(String name);

	public List<zuVO> findzuList2();
}
