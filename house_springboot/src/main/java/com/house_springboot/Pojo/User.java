package com.house_springboot.Pojo;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("User")
public class User {
    @ApiModelProperty(value = "id", example = "3")
    private Integer id;
    @ApiModelProperty(value = "username", example = "3333")
    private String username;

    @ApiModelProperty(value = "password", example = "3333")
    private String password;

    @ApiModelProperty(value = "type", example = "3333")
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", type=" + type + "]";
	}
    
    
}