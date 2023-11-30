package com.house_springboot.Pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("QueryVo")
public class QueryVo {
	@ApiModelProperty(value = "zuname", example = "3333")
private String zuname;
	@ApiModelProperty(value = "fromdate", example = "3333")
private String fromdate;
	@ApiModelProperty(value = "todate", example = "3333")
private String todate;
	@ApiModelProperty(value = "userlistId", example = "3")
private Integer userlist_id;

public Integer getUserlist_id() {
	return userlist_id;
}
public void setUserlist_id(Integer userlist_id) {
	this.userlist_id = userlist_id;
}
public String getZuname() {
	return zuname;
}
public void setZuname(String zuname) {
	this.zuname = zuname;
}
public String getFromdate() {
	return fromdate;
}
public void setFromdate(String fromdate) {
	this.fromdate = fromdate;
}
public String getTodate() {
	return todate;
}
public void setTodate(String todate) {
	this.todate = todate;
}

	
}
