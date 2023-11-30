package com.house_springboot.service;

import com.house_springboot.Pojo.Houselist;
import com.house_springboot.dao.HouselistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouselistServiceImpl implements HouselistService {
	
	@Autowired
	private HouselistMapper houselistMapper;
	
	@Override
	public List<Houselist> selectAll() {
		List<Houselist> houselist=houselistMapper.selectAll();
		return houselist;
	}

	@Override
	public Houselist findhouseid(String houseid) {
		Houselist houselist=houselistMapper.findhouseid(houseid);
		return houselist;
	}

	@Override
	public void inserthouse(Houselist houselist) {
		// TODO Auto-generated method stub
		houselistMapper.inserthouse(houselist);
	}

	@Override
	public void deletehouse(int id) {
		// TODO Auto-generated method stub
		houselistMapper.deletehouse(id);
	}

	@Override
	public Houselist findhouseidupdate(Houselist houselist) {
		Houselist list=houselistMapper.findhouseidupdate(houselist);
		return list;
	}

	@Override
	public void updatehouse(Houselist houselist) {
		houselistMapper.updatehouse(houselist);
		
	}

	@Override
	public Houselist findid(int id) {
		Houselist list=houselistMapper.findid(id);
		return list;
	}

	@Override
	public void updatehousestatus(Houselist houselist) {
		// TODO Auto-generated method stub
		houselistMapper.updatehousestatus(houselist);
	}

	@Override
	public void deletehousebyhouseid(String house_id) {
		houselistMapper.deletehousebyhouseid(house_id);
		
	}

	@Override
	public Houselist selectByAddress(String name) {
		Houselist findaddress = houselistMapper.findaddress(name);
		return findaddress;
	}


}
