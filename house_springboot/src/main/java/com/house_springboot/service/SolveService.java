package com.house_springboot.service;


import com.house_springboot.Pojo.QueryVo;
import com.house_springboot.Pojo.Solve;
import com.house_springboot.Pojo.Wrong;

import java.util.List;

public interface SolveService {
	public List<Solve> selectall(QueryVo vo);
	public Integer selectcount(QueryVo vo);
	public void deletesolve(Integer id);
	
	public List<Wrong> findwrong(QueryVo vo);
	public Wrong findbyid(Integer id);
	 public void insertwrong(Wrong wrong);
	 public void gotosolve(Integer id, Solve solve);
}
