package com.house_springboot.Pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("Schedule")
public class Schedule {
	@ApiModelProperty(value = "id", example = "3")
	private Integer id;
	@ApiModelProperty(value = "date", example = "3333")
	private String date;
	@ApiModelProperty(value = "content", example = "3333")
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
