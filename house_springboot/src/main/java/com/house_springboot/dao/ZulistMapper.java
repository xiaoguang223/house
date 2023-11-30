package com.house_springboot.dao;


import com.house_springboot.Pojo.Zulist;
import com.house_springboot.VO.zuVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ZulistMapper {
	public void insertzulist(Zulist zulist);
	public List<Zulist> findzuuserlist() throws Exception;
	Zulist findzulist(String house_id);
	public void deletezulist(String house_id);
	public List<Zulist> findzulistbyuid(Integer userlist_id);
	public Zulist findzukezulist(Integer id);

    public List<zuVO> findzuList(String name);

	public List<zuVO> findzuList2();
}
