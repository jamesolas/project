package com.app.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.model.Customer;

class CustomerCrudDAOImplTest {
	private static CustomerCrudDAOImpl services;

	@BeforeAll
	public static void setupMyServices() {
		services=new CustomerCrudDAOImpl();
	}
//	@Test
//	void testCreateCustomer() {
//	//	Customer customer.getCustomerFirstName();
//	}
//	
//	@Test
//	void testGetCustomerFirstName() {
//		String output = "man";
	//	assertEquals(output, services.getCustomerFirstName());
//	}

//	@Test
//	void testCreateBalance() {
//		long output = 100;
//		assertEquals(output, services.createBalance(100));
//	}
//
//	@Test
//	void testDeleteCustomer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeposit() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testWithdraw() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSendMoney() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testReceiveMoney() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateTransactions() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateAccounts() {
//		fail("Not yet implemented");
//	}

}
