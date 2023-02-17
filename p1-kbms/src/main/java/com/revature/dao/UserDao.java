package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.User;



public interface UserDao {


	User findUser(String userId, String userPass);

	List<User> allUsers() throws SQLException;

	User findUser(String userId);

}
