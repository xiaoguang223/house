package com.house_springboot.Pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.sql.Date;

@Data
@ApiOperation("Topaid")
public class Topaid {
	@ApiModelProperty(value = "id", example = "3")
	private Integer id;
	@ApiModelProperty(value = "houseId", example = "3333")
	private String house_id;
	@ApiModelProperty(value = "address", example = "3333")
	private String address;
	@ApiModelProperty(value = "date")
	private Date date;
	@ApiModelProperty(value = "price", example = "3")
	private Double price;
	@ApiModelProperty(value = "name", example = "3333")
	private String name;
	@ApiModelProperty(value = "userlistId", example = "3")
	private Integer userlist_id;
	@ApiModelProperty(value = "status", example = "3333")
	private String status;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserlist_id() {
		return userlist_id;
	}
	public void setUserlist_id(Integer userlist_id) {
		this.userlist_id = userlist_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
