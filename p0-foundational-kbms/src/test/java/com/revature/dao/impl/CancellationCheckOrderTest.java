package com.revature.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

import com.revature.dao.CancellationDaoImpl;

public class CancellationCheckOrderTest {
	@Test
	public void invalidOrderTest() {
		CancellationDaoImpl cancelDao = new CancellationDaoImpl();
		Scanner in = new Scanner(System.in);
		int oid = in.nextInt();
		cancelDao.checkOrder(oid);
		boolean check = CancellationDaoImpl.checkTest;
		boolean f = false;
		assertEquals(check, f);
		
	}

}
