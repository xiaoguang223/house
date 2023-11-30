package com.house_springboot.Pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("checkout")
public class Checkout {

	@ApiModelProperty(value = "id", example = "1")
	private Integer id;
	@ApiModelProperty(value = "houseId", example = "1")
	private String house_id;
	@ApiModelProperty(value = "address", example = "3333")
	private String address;
	@ApiModelProperty(value = "status", example = "3333")
	private String status;
	@ApiModelProperty(value = "userlistId", example = "1")
	private Integer userlist_id;
	@ApiModelProperty(value = "userlist")
	private Userlist userlist;
	
	public Userlist getUserlist() {
		return userlist;
	}
	public void setUserlist(Userlist userlist) {
		this.userlist = userlist;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHouse_id() {
		return house_id;
	}
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getUserlist_id() {
		return userlist_id;
	}
	public void setUserlist_id(Integer userlist_id) {
		this.userlist_id = userlist_id;
	}
	
}
