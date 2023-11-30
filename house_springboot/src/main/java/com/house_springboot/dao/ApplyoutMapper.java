package com.house_springboot.dao;


import com.house_springboot.Pojo.Applyout;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApplyoutMapper {
	public void insertapplyout(Applyout applyout);
	List<Applyout> findallapplyout();
	public void updateapplyout(Applyout applyout);
	public void updateapplyoutbyhouse(Applyout applyout);
	public Applyout findbyid(Integer id);
	public void deleteapplyout(Integer id);
}
