package com.house_springboot.service;
import com.house_springboot.Pojo.User;

import java.util.List;

public interface UserService {

	public List<User> userList() throws Exception;
	public User login(User user) throws Exception;
	
}
