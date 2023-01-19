package com.revature.constants;

public class Constants {
	public static final String SELECT_ORDER_QUERY = "SELECT `O`.`ORDER_ID`,`O`.`PREFERRED_LOGIN_ID`,`O`.`PRODUCT_ID`,`P`.`PRODUCT_NAME`,`O`.`QUANTITY`,`O`.`TOTAL_PRICE` ,`O`.`ORDER_DATE` FROM `kbms_project`.`ORDER_DETAILS` `O` JOIN `kbms_project`.`PRODUCT` `P` ON `P`.`PRODUCT_ID` = `O`.`PRODUCT_ID` WHERE `O`.`STATUS`='CONFIRMED'";
	public static final String UPDATE_STATUS = "UPDATE order_details SET STATUS = 'Cancelled', CANCELLATION_ID =?, CANCELLATION_DATE =?, CANCELLATION_REASON = ? WHERE ORDER_ID= ? ";
	public static final String GET_ORDER_DETAILS = "SELECT * FROM ORDER_DETAILS";
	public static final String WELCOME_MESSAGE = "****WELCOME TO KITCHEN BASKET *****";
	public static final String SIGN_IN = "1. Sign In";
	public static final String EXIT = "2. Exit";


	public static final String UPDATE_COUNT = "UPDATE PRODUCT p join order_details o on p.PRODUCT_ID=o.PRODUCT_ID set PRODUCT_COUNT = (p.PRODUCT_COUNT + o.QUANTITY ) where p.PRODUCT_ID = ? ";

	public static final String GET_PID = "SELECT PRODUCT_ID FROM ORDER_DETAILS WHERE ORDER_ID = ? ";

}
