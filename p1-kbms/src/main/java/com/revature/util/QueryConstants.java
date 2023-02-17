package com.revature.util;

public class QueryConstants {
	public static final String INSERT_USER = "INSERT INTO GD_LOGIN VALUES(?,?,?)";
	public static final String UPDATE_USER = "UPDATE GD_LOGIN SET LOGIN_ID=?,PASSWORD=?,ROLE=? WHERE  preferred_login_id=?";
	public static final String DELETE_USER= "DELETE FROM GD_LOGIN WHERE preferred_login_id=?";
	
	public static final String SELECT_USER = "SELECT * FROM customer WHERE preferred_login_id=? AND PASSWORD=?";
	public static final String SELECT_USER_BY_ID = "SELECT * FROM customer WHERE preferred_login_id=?";
	public static final String SELECT_ALL_USER = "SELECT * FROM customer ORDER BY ROLE";
	public static final String SELECT_USERS_BY_ID_PATTERN = "SELECT * FROM GD_LOGIN WHERE preferred_login_id LIKE ?";

}


//SELECT * FROM GD_ACCOUNT;
//
//DROP TABLE GD_LOGIN;
//CREATE TABLE GD_LOGIN
//(
//  LOGIN_ID VARCHAR(200),
//  PASSWORD VARCHAR(200),
//  ROLE VARCHAR2(20)
//);
//
//INSERT INTO GD_LOGIN VALUES('N001','123','normal');
//INSERT INTO GD_LOGIN VALUES('N002','123','normal');
//INSERT INTO GD_LOGIN VALUES('N003','123','normal');
//INSERT INTO GD_LOGIN VALUES('N004','123','normal');
//INSERT INTO GD_LOGIN VALUES('N005','123','normal');
//
//INSERT INTO GD_LOGIN VALUES('A001','123','admin');
//INSERT INTO GD_LOGIN VALUES('A002','123','admin');
//INSERT INTO GD_LOGIN VALUES('A003','123','admin');
//INSERT INTO GD_LOGIN VALUES('A004','123','admin');
//INSERT INTO GD_LOGIN VALUES('A005','123','admin');
//
//COMMIT;
//SELECT * FROM GD_Login;