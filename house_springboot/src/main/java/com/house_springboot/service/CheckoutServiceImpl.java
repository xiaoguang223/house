package com.house_springboot.service;

import com.house_springboot.Pojo.Checkout;
import com.house_springboot.VO.CheckoutVO;
import com.house_springboot.dao.CheckoutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CheckoutServiceImpl implements CheckoutService {
	
	@Autowired
	private CheckoutMapper checkoutMapper;

	@Override
	public void insertcheckout(Checkout checkout) {
		checkoutMapper.insertcheckout(checkout);
		
	}

	@Override
	public List<Checkout> getallcheckout() {
		List<Checkout> checkout=checkoutMapper.getallcheckout();
		return checkout;
	}

	@Override
	public void deletecheckout(Integer id) {
		
		checkoutMapper.deletecheckout(id);
	}

	@Override
	public CheckoutVO selectone(String name) {
		CheckoutVO selectone = checkoutMapper.selectone(name);
		return selectone;
	}

	@Override
	public List<CheckoutVO> selectall() {
		List<CheckoutVO> selectall = checkoutMapper.selectall();
		return selectall;
	}


}
