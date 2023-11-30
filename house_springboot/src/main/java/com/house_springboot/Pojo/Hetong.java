package com.house_springboot.Pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("Hetong")
public class Hetong {
	@ApiModelProperty(value = "id", example = "1")
private Integer id;
	@ApiModelProperty(value = "chuzu", example = "3333")
private String chuzu;
	@ApiModelProperty(value = "chuzuIdcard", example = "3333")
private String chuzu_idcard;
	@ApiModelProperty(value = "zuke", example = "3333")
private String zuke;
	@ApiModelProperty(value = "zuke_idcard", example = "3333")
private String zuke_idcard;
	@ApiModelProperty(value = "fromdate", example = "3333")
private String fromdate;
	@ApiModelProperty(value = "todate", example = "3333")
private String todate;
	@ApiModelProperty(value = "price", example = "1")
private double price;
	@ApiModelProperty(value = "address", example = "3333")
private String address;
	@ApiModelProperty(value = "house_id", example = "1")
private String house_id;
	@ApiModelProperty(value = "payday", example = "3")
private Integer payday;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getChuzu() {
	return chuzu;
}
public void setChuzu(String chuzu) {
	this.chuzu = chuzu;
}
public String getChuzu_idcard() {
	return chuzu_idcard;
}
public void setChuzu_idcard(String chuzu_idcard) {
	this.chuzu_idcard = chuzu_idcard;
}
public String getZuke() {
	return zuke;
}
public void setZuke(String zuke) {
	this.zuke = zuke;
}
public String getZuke_idcard() {
	return zuke_idcard;
}
public void setZuke_idcard(String zuke_idcard) {
	this.zuke_idcard = zuke_idcard;
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
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getHouse_id() {
	return house_id;
}
public void setHouse_id(String house_id) {
	this.house_id = house_id;
}
public Integer getPayday() {
	return payday;
}
public void setPayday(Integer payday) {
	this.payday = payday;
}

}
