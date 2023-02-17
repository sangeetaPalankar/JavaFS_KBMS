package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.util.ConnectionFactory;
import com.revature.util.DbUtil;
import com.revature.util.QueryConstants;


public class UserDaoImpl implements UserDao {

	private Connection connection;
	private PreparedStatement preparedStatment;

	public UserDaoImpl() {
	}

	

	@Override
	public User findUser(String userId, String userPass) {

		ResultSet rs = null;
		User found = null;

		try {
			connection = ConnectionFactory.getConnection();
			preparedStatment = connection.prepareStatement(QueryConstants.SELECT_USER);
			preparedStatment.setString(1, userId);
			preparedStatment.setString(2, userPass);
			rs = preparedStatment.executeQuery();
			if (rs.next()) {
				found = new User(rs.getString(1), rs.getString(2));
			}

		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return found;
	}
	
	@Override
	public User findUser(String userId) {

		ResultSet rs = null;
		User found = null;

		try {
			connection = ConnectionFactory.getConnection();
			preparedStatment = connection.prepareStatement(QueryConstants.SELECT_USER_BY_ID);
			preparedStatment.setString(1, userId.toUpperCase());
			rs = preparedStatment.executeQuery();
			if (rs.next()) {
				found = new User(rs.getString(1), rs.getString(2));
			}

		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return found;
	}

	@Override
	public List<User> allUsers() throws SQLException {

		ResultSet rs = null;
		List<User> foundList = new ArrayList<User>();
		User currentUser = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatment = connection.prepareStatement(QueryConstants.SELECT_ALL_USER);
			rs = preparedStatment.executeQuery();
			while (rs.next()) {
				currentUser = new User(rs.getString(1), rs.getString(2));
				foundList.add(currentUser);
			}
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return foundList;
	}

}
