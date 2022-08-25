package com.app.service;

import com.app.dto.InputRequest;
import com.app.dto.UserRequest;
import com.app.model.User;

public class UserService {
	public User register() {
		return InputRequest.register();

	}

	public UserRequest login() {
		return InputRequest.login();

	}

}
