package com.joyadata.tjlog.dao;

import org.apache.ibatis.annotations.Param;

import com.joyadata.tjlog.model.User;

public interface IUserDao {

	User getUser(@Param("username") String username, @Param("password") String password);

}
