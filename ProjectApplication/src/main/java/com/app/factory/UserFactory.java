package com.app.factory;

import com.app.dao.USerDao;
import com.app.dao.impl.UserDaoImpl;

public class UserFactory {
	public static USerDao getUser() {
		return new UserDaoImpl();
	}

}
