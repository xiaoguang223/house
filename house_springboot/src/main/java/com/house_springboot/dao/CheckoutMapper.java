package com.house_springboot.dao;


import com.house_springboot.Pojo.Checkout;
import com.house_springboot.VO.CheckoutVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CheckoutMapper {
	public void insertcheckout(Checkout checkout);
	public List<Checkout> getallcheckout();
	public void deletecheckout(Integer id);
    public CheckoutVO selectone(String name);

	public List<CheckoutVO> selectall();

}
