package com.revature.kbms.dao;
import java.math.BigInteger;
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.revature.kbms.model.Cancellation;
import com.revature.kbms.model.Order;
import com.revature.kbms.util.DateTimeUtil;

public class CancellationDaoImpl implements CancellationDao{
	
	public void ListCreation() {		
		Order o=new Order(1001,"Onion", 5, 50.00, "Confirmed");
		Order o1=new Order(1002,"Tomato", 2, 40.00, "Confirmed");
		Order o2=new Order(1012,"Turmeric", 6, 60.00, "Confirmed");
		Order o3=new Order(1007,"Coffee", 20, 150.00, "Confirmed");
		CancellationDao.orderlist.add(o);
		CancellationDao.orderlist.add(o1);
		CancellationDao.orderlist.add(o3);
		CancellationDao.orderlist.add(o2);
	
	}
	
	public void displayOrderlist() {
		for(Order o: CancellationDao.orderlist ) {
			System.out.println(o);
			
		}
	}
	
	
	
	
		
	//private static Connection con = DatabaseConnection.getConnection();
	
	public static void main(String[] args) {
		//CancellationDaoImpl obj = new CancellationDaoImpl();
		//System.out.println(n  obj.generateCancellationId(123));
	
				
	}

	@Override
	public void getCancelOrderDetails(int orderId) {

		// TODO Auto-generated method stub
		
	}
/*
	@Override
	public void setStatusCancelled(int orderId) {
		String statusCancel = Constant.UPDATE_STATUS;
		PreparedStatement ps = con.preparedStatement(statusCancel);
		ps.setString(orderId, statusCancel);
		
	}
*/
	@Override
	public String generateCancellationId(int orderId) {
		String generateUUIDNo = String.format("%010d",new BigInteger(UUID.randomUUID().toString().replace("-",""),16));
		String cancelId = generateUUIDNo.substring( generateUUIDNo.length() - 10);
        return cancelId;
		
	}

	@Override
	public void getCancelTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reflectChanges(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayCancellationDetails(int orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatusCancelled(int orderId, String cancelTime) {
		// TODO Auto-generated method stub
		
	}
	
	

}
