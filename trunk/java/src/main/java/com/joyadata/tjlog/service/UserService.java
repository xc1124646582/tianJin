package com.joyadata.tjlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyadata.tjlog.dao.IUserDao;
import com.joyadata.tjlog.model.User;

@Service
public class UserService {

	@Autowired
	private IUserDao dao;

	public User getUser(String username, String password) {
		return dao.getUser(username, password);
	}

}
