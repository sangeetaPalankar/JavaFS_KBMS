package com.revature.kbms.dao;
import java.math.BigInteger;
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.util.UUID;

import com.revature.kbms.constants.Constant;

public class CancellationDaoImpl implements CancellationDao{
	
	private static Connection con = DatabaseConnection.getConnection();
	
	public static void main(String[] args) {
		CancellationDaoImpl obj = new CancellationDaoImpl();
		//System.out.println(n  obj.generateCancellationId(123));
	
				
	}

	@Override
	public void getCancelOrderDetails(int orderId) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatusCancelled(int orderId) {
		String statusCancel = Constant.UPDATE_STATUS;
		PreparedStatement ps = con.preparedStatement(statusCancel);
		ps.setString(orderId, statusCancel);
		
	}

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
	
	

}
