package com.house_springboot.service;

import com.house_springboot.Pojo.Paid;
import com.house_springboot.Pojo.QueryVo;
import com.house_springboot.Pojo.Topaid;
import com.house_springboot.dao.PaidMapper;
import com.house_springboot.dao.TopaidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TopaidServiceImpl implements TopaidService {
	@Autowired
	private TopaidMapper topaidMapper;
	@Autowired
	private PaidMapper paidMapper;
	@Override
	public void inserttopaid(Topaid topaid) {
		topaid.setStatus("租金未缴");
		topaidMapper.inserttopaid(topaid);
	}
	@Override
	public List<Topaid> findtopaid(QueryVo vo) {
		List<Topaid> list=topaidMapper.findtopaid(vo);
		return list;
	}
	@Override
	public Topaid findbyid(Integer id) {
		Topaid topaid=topaidMapper.findbyid(id);
		return topaid;
	}
	@Override
	public void gotopay(Integer id, Paid paid) {
		paidMapper.insertpaid(paid);
		topaidMapper.deletetopaid(id);
		
	}

}
