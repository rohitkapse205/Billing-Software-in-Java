package com.app.dao;

import java.util.List;

import com.app.dto.UserRequest;
import com.app.model.User;

public interface USerDao {
	int register(User user);

	User login(UserRequest request);

	List<User> listOfUsers();

	User findById(int id);

	
}
