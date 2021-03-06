package com.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;

class CustomerSearchServiceImplTest {
	
private static CustomerSearchServiceImpl services;
	
	@BeforeAll
	public static void setupCustomerSearchImpl() {
		services=new CustomerSearchServiceImpl();
	}

	@Test
	void testCustomerLogin() {
		String customerEmail = "email";
		String customerPassword = "pass";
		//String input = customerEmail + ""
		Customer customer = new Customer();
		//Customer customer = Customer.setCustomerEmail("email");
		assertEquals(customerEmail, customer.getCustomerEmail());
		//assertThat(customerEmail.)
	}

//	@Test
//	void testViewBalance() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testFindCustomerId() throws BusinessException {
		long output = 1;
		String customerEmail = "email";
		assertEquals(output, services.findCustomerId(customerEmail));
	}
//
//	@Test
//	void testFindAccountNumber() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindBalance() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindReceiving() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testEmployeeLogin() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testViewCustomerBalances() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testViewAllTransactions() {
//		fail("Not yet implemented");
//	}

}
