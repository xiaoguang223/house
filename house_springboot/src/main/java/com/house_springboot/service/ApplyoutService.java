package com.house_springboot.service;


import com.house_springboot.Pojo.Applyout;
import com.house_springboot.Pojo.Zulist;

import java.util.List;
public interface ApplyoutService {
	public void insertapplyout(Zulist zulist);
	List<Applyout> findallapplyout();
	public void updateapplyout(Applyout applyout);
	public void agreeapplyout(Integer id);
	public void deleteapplyout(Integer id);
}
