package com.revature.app.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.CancellationDao;
import java.util.Scanner;
import com.revature.dao.CancellationDaoImpl;

import com.revature.constants.Constants;

import com.revature.model.Order;
import com.revature.util.DateTimeUtil;

public class MenuDrivenApplication {
	private static final Logger logger = logger.getLogger(BatchDetailsImplementation.class);
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {	
		showMenu();
	}
	
	public static void showMenu() throws SQLException {
		System.out.println(Constants.WELCOME_MESSAGE);
		System.out.println("=======================================");
		System.out.println(Constants.SIGN_IN);
		System.out.println(Constants.EXIT);

		char choice = 'y';
		do {
			choice = in.next().charAt(0);
			in.nextLine();

			switch (choice) {
			case '1':
				signIn();
				break;
			case '2':
				System.out.println("**Thank You Visit Again!**");
				System.exit(0);
				break;
			default:
				System.out.println("\t\t Enter a valid option");
			}
		} while (choice != 'n');
	}

	
	public static void signIn() throws SQLException {//throws SQLException {
		
		System.out.print("Enter Login Id: ");
		String loginId = in.nextLine();
		
		System.out.print("Enter Password: ");
		String password = in.nextLine();
		
		
		System.out.println("********You are successfully logged in! ********");
		System.out.println("============================================");
		System.out.println("\t \t WELCOME BACK "+ loginId + " !" );
		
		cancelOrders();
	}
	
	
	public static void cancelOrders() throws SQLException {
		CancellationDaoImpl impl = new CancellationDaoImpl();
		CancellationDaoImpl olist = new CancellationDaoImpl();
		Order order = new Order();
		CancellationDaoImpl c = new CancellationDaoImpl();
		
		char ch;
		do {
			System.out.println("=================================================");
			System.out.println("\n \t \t YOUR PLACED ORDERS: \n");
			impl.displayOrderlist();
			System.out.println("=================================================");
			System.out.println("Do you want to Cancel any order? \nPress y or n?");
			ch = in.next().charAt(0);
			in.nextLine();
			if(ch =='y')
			{
				System.out.println("Enter the Details to Cancel: ");
				System.out.println();
				System.out.println("Order ID: ");
				int oId = in.nextInt();
				in.nextLine();
				
				c.checkOrder(oId); //call method to check if valid order 
				
				System.out.println("Reason: ");
				String reason = in.next();
				in.nextLine();
	
				System.out.println("Are you sure to cancel order "+oId+" ?\n y or n");
				char ch2 = in.next().charAt(0);
				in.nextLine();
		
				if (ch2 == 'y') {
					c.getCancelOrderDetails(oId, reason);
					System.out.println("Order Cancelled sucessfully..");
					System.out.println();
					
							
					System.out.println("View Cancellation details? \n y or n");
					char ch3 = in.next().charAt(0);
					in.nextLine();
					if(ch3 =='y') {
						c.displayCancellationDetails(oId);
						for(Order j: CancellationDao.cancelList ) {
							System.out.println(j);	
						}
						
					}
							
				}
						
			}	
			
		}while(ch == 'y');
		
		System.out.println();
		System.out.println("Thank You Visit Again");
		System.out.println();
		showMenu();
	}
}


		
	
