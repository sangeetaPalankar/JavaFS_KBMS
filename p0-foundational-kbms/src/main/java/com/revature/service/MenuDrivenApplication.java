package com.revature.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.CancellationDao;
import java.util.Scanner;
import com.revature.dao.CancellationDaoImpl;
import com.revature.config.DatabaseConnection;
import com.revature.constants.Constants;

import com.revature.model.Order;
import com.revature.util.DateTimeUtil;

public class MenuDrivenApplication {
	private static final Logger logger = Logger.getLogger(MenuDrivenApplication.class);
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {	
		showMenu();
	}
	
	public static void showMenu() throws SQLException {
		logger.info(Constants.WELCOME_MESSAGE);
		logger.info("=======================================");
		logger.info(Constants.SIGN_IN);
		logger.info(Constants.EXIT);

		char choice = 'y';
		do {
			choice = in.next().charAt(0);
			in.nextLine();

			switch (choice) {
			case '1':
				login();
				break;
			case '2':
				logger.info("**Thank You Visit Again!**");
				System.exit(0);
				break;
			default:
				logger.info("\t\t Enter a valid option");
			}
		} while (choice != 'n');
	}
	
	
	
	
	public static void login() throws SQLException {

		try(Connection connection = DatabaseConnection.getConnection();){
				Statement statement = connection.createStatement();
		// Get input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		String username = sc.nextLine();
		System.out.print("Password: ");
		String password = sc.nextLine();
			// Execute a query
		    
			logger.info("Checking credentials...");

			String sql;
			sql = "SELECT * FROM customer WHERE preferred_login_id = '" + username + "' AND password = '" + password + "'";
			ResultSet rs = statement.executeQuery(sql);
			
			// Extract data from result set
			
			if (rs.next()) {
				// Retrieve by column name
				String customerName = rs.getString("preferred_login_id");
				String customerPassword = rs.getString("password");

				// Display values
				logger.info("\n");
				logger.info("-------------Welcome, " + customerName + "!----------------");
				cancelOrders();
			} else {
				Scanner scan = new Scanner(System.in);
				logger.info("Invalid username or password.");
				logger.info("You are not a registered user");
				showMenu();
				
			}
		}
	}
	
	
	public static void cancelOrders() throws SQLException {
		CancellationDaoImpl impl = new CancellationDaoImpl();
		CancellationDaoImpl olist = new CancellationDaoImpl();
		Order order = new Order();
		CancellationDaoImpl c = new CancellationDaoImpl();
		char ch;
		do {
			logger.info("=================================================");
			logger.info("\n \t \t \t \t \t \t \t\t\t\t\t YOUR PLACED ORDERS: \n");
			impl.displayOrderlist();
			logger.info("=================================================");
			logger.info("Do you want to Cancel any order? \nPress y or n?");
			ch = in.next().charAt(0);
			in.nextLine();
			if(ch =='y')
			{
				logger.info("Enter the Details to Cancel: ");
				logger.info("\n");
				logger.info("Order ID: ");
				int oId = in.nextInt();
				in.nextLine();
				
				c.checkOrder(oId); //call method to check if valid order 
				
				logger.info("Reason: ");
				String reason = in.next();
				in.nextLine();
	
				logger.info("Are you sure to cancel order "+oId+" ?\n y or n");
				char ch2 = in.next().charAt(0);
				in.nextLine();
		
				if (ch2 == 'y') {
					c.cancelOrder(oId, reason);
					logger.info("Order Cancelled sucessfully..");
					logger.info("\n");
					
							
					logger.info("View Cancellation details? \n y or n");
					char ch3 = in.next().charAt(0);
					in.nextLine();
					if(ch3 =='y') {
						c.displayCancellationDetails(oId);
						
						for(Order j: CancellationDao.cancelList ) {
							logger.info(j);	
						}	
					}	
				}	
			}	
		}while(ch == 'y');
		logger.info("\n");
		logger.info("Thank You Visit Again");
		logger.info("\n");
		showMenu();
	}
}


		
	
