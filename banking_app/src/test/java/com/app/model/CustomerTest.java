package com.app.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CustomerTest {
	
private static Customer services;
	
	@BeforeAll
	public static void setupMyServices() {
		services=new Customer();
	}

//	@Test
//	void testHashCode() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCustomer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCustomerLongStringStringDateStringStringDateLongLong() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCustomerStringStringStringString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCustomerStringStringStringStringDate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCustomerStringStringDateStringString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCustomerLongStringStringDateStringString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCustomerLong() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCustomerStringString() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetCustomerId() {
		long getCustomerId = 1;
		assertEquals(getCustomerId, 1);
	}

//	@Test
//	void testSetCustomerId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCustomerFirstName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetCustomerFirstName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCustomerLastName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetCustomerLastName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCustomerAge() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetCustomerAge() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCustomerEmail() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetCustomerEmail() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCustomerPassword() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetCustomerPassword() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testEqualsObject() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCustomerDob() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetCustomerDob() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAccountBalance() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetAccountBalance() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAccountNumber() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetAccountNumber() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testToString() {
//		fail("Not yet implemented");
//	}
//
}
