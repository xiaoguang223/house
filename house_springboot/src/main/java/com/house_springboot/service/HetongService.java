package com.house_springboot.service;


import com.house_springboot.Pojo.Hetong;

public interface HetongService {

	public void inserthetong(Hetong hetong);
	public Hetong findhetong(String house_id);
	public void updatehetong(Hetong hetong);
	public void deletehetong(String house_id);
}
