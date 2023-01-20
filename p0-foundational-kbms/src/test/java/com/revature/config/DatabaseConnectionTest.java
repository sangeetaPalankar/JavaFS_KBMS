package com.revature.config;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
public class DatabaseConnectionTest {
	@Test
	public void testGetConnection() {
		assertNotNull(new DatabaseConnection().getConnection());
	}

}
