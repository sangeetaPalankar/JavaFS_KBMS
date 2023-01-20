package com.revature.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.revature.dao.CancellationDao;
import com.revature.dao.CancellationDaoImpl;
import com.revature.model.Order;

public class CancellationDisplayCancelTest {
	
	@Test
	public void test() {
		CancellationDaoImpl cancelDao = new CancellationDaoImpl();
		cancelDao.displayCancellationDetails(10002);
		List<Order> b = CancellationDaoImpl.cancelList;
		assertEquals(b, CancellationDaoImpl.cancelList);
		
	}

}
