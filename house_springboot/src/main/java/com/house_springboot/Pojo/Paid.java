package com.house_springboot.Pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.sql.Date;

@Data
@ApiOperation("Paid")
public class Paid {
	@ApiModelProperty(value = "id", example = "3")
private Integer id;
	@ApiModelProperty(value = "house_id", example = "3333")
private String house_id;
	@ApiModelProperty(value = "address", example = "3333")
private String address;
	@ApiModelProperty(value = "date")
private Date date;
	@ApiModelProperty(value = "price", example = "3")
private Double price;
	@ApiModelProperty(value = "paydate", example = "3333")
private String paydate;
	@ApiModelProperty(value = "name", example = "3333")
private String name;
	@ApiModelProperty(value = "userlist_id", example = "3")
private Integer userlist_id;
	@ApiModelProperty(value = "status", example = "3333")
private String status;

public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
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
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getPaydate() {
	return paydate;
}
public void setPaydate(String paydate) {
	this.paydate = paydate;
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
