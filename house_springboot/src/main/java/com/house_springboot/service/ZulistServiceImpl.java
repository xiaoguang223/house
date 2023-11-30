package com.house_springboot.service;

import com.house_springboot.Pojo.Zulist;
import com.house_springboot.VO.zuVO;
import com.house_springboot.dao.ZulistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZulistServiceImpl implements ZulistService {
	
	@Autowired
	private ZulistMapper zulistMapper;
	
	@Override
	public void insertzulist(Zulist zulist) {
		zulistMapper.insertzulist(zulist);
		
	}

	@Override
	public List<Zulist> findzuuserlist() throws Exception {
		List<Zulist> zulist=zulistMapper.findzuuserlist();
		
		return zulist;
	}

	@Override
	public Zulist findzulist(String house_id) {
		Zulist zulist=zulistMapper.findzulist(house_id);
		return zulist;
	}

	@Override
	public void deletezulist(String house_id) {
		zulistMapper.deletezulist(house_id);
		
	}

	@Override
	public List<Zulist> findzulistbyuid(Integer userlist_id) {
		List<Zulist> zulist=zulistMapper.findzulistbyuid(userlist_id);
		return zulist;
	}

	@Override
	public List<zuVO> findzuList(String name) {
		List<zuVO> zuVOS = zulistMapper.findzuList(name);
		return zuVOS;
	}

	@Override
	public List<zuVO> findzuList2() {
		List<zuVO> zuVOS = zulistMapper.findzuList2();
		return zuVOS;
	}

}
