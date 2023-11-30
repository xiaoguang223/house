package com.house_springboot.service;

import com.house_springboot.Pojo.Checkout;
import com.house_springboot.VO.CheckoutVO;

import java.util.List;

public interface CheckoutService {
public void insertcheckout(Checkout checkout);
public List<Checkout> getallcheckout();
public void deletecheckout(Integer id);

public CheckoutVO selectone(String name);

    public List<CheckoutVO> selectall();

}
