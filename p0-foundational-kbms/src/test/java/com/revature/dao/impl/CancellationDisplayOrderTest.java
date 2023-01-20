package com.revature.dao.impl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.revature.dao.CancellationDao;
import com.revature.dao.CancellationDaoImpl;
import com.revature.model.Order;

public class CancellationDisplayOrderTest {
	@Test
	public void test() {
		CancellationDaoImpl cancelDao = new CancellationDaoImpl();

		int b = CancellationDaoImpl.orderCount;
		assertEquals(b, CancellationDaoImpl.orderCount);
		
	}

}
