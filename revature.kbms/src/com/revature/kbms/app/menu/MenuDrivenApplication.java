package com.revature.kbms.app.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.revature.kbms.dao.CancellationDao;
import java.util.Scanner;
import com.revature.kbms.dao.CancellationDaoImpl;
import com.revature.kbms.constants.Constants;
import com.revature.kbms.model.Cancellation;
import com.revature.kbms.model.Order;
import com.revature.kbms.util.DateTimeUtil;

public class MenuDrivenApplication {
	
	
	
	public static void main(String[] args) {
		
		showMenu();
	}
	
	static Scanner in = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println(Constants.WELCOME_MESSAGE);
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

	
	public static void signIn() {//throws SQLException {
		CancellationDaoImpl olist = new CancellationDaoImpl();
		System.out.println(Constants.CUSTOMER_PREFFERED_LOGINID);
		String loginId = in.nextLine();
		
		System.out.print(Constants.PASSWORD);
		String password = in.nextLine();
		
		System.out.println("********You are successfully logged in*******");
		System.out.println();
		System.out.println("WELCOME BACK "+ loginId + " !" );
		System.out.println();
		olist.ListCreation();
		cancelOrders();
	}
	
	public static void cancelOrders() {
		
		CancellationDaoImpl olist = new CancellationDaoImpl();
		Order order = new Order();
		Cancellation cancel = new Cancellation();
		CancellationDaoImpl c = new CancellationDaoImpl();
		boolean flag = false;
		
		char ch;
		do {
			System.out.println("\n Your Placed Orders: \n");
			olist.displayOrderlist();
			System.out.println();
			System.out.println("Do you want to Cancel any order? \n y or n");
			ch = in.next().charAt(0);
			in.nextLine();
			if(ch =='y')
			{
				System.out.println("Enter OrderId to Cancel");
				System.out.println("OrderID: ");
				int oid = in.nextInt();
				in.nextLine();
				
				for(Order i: CancellationDao.orderlist) {
					if(i.getOrderId() == oid){
						flag = true;
						if(i.getStatus().equals("Cancelled")) {
							System.out.println("Already Cancelled");
							cancelOrders();
						}
					} 
				}
				if(!flag) {
						System.out.println("No order found with Order Id "+oid);
						cancelOrders();
				}
				
				System.out.println("Reason: ");
				String reason = in.next();
				in.nextLine();
		
				System.out.println("Are you sure to cancel order "+oid+" ?\n y or n");
				char ch2 = in.next().charAt(0);
				in.nextLine();
		
				if (ch2 == 'y') {
					for(Order o: CancellationDao.orderlist) {
						if(o.getOrderId() == oid){
							o.setStatus("Cancelled");
							
							cancel.setCancellationId();
							cancel.setCancellationDate(DateTimeUtil.getCurrentDateTime());
							cancel.setCancellationReason(reason);
							cancel.setOrderId(oid);
							CancellationDao.cancelList.add(cancel);
							System.out.println("Order Cancelled sucessfully..");
							System.out.println();
							
							System.out.println("View Cancellation details? \n y or n");
							char ch3 = in.next().charAt(0);
							in.nextLine();
							if(ch3 =='y') {
								for(Cancellation j: CancellationDao.cancelList ) {
									System.out.println(j);	
								}
							}
							
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
		
	
