package com.app.service.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.service.impl.CustomerCrudServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class ServicesTest {
	
	private static CustomerCrudServiceImpl services;
	
	@BeforeAll
	public static void setupCustomerCrudService() {
		services = new CustomerCrudServiceImpl();
	}
	
	@Test
	public void testDeposit() {			
		long output = 100;
		try {
			Customer customer;
			//Customer customer = Customer(100, 1);
			//Customer customer = deposit(100, 1);
			//assertNotNull(customer);
			//assertEquals(output, services.deposit(100, 1));
			assertEquals("CustomerAccount [accountNumber=0, customerId=1, accountBalance=0, amount=100, date=null]", services.deposit(100, 1));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("failed");
		}
		}
	//@Mock Customer customer;
	//@Mock private ExternalClass externalClass;
	//@Mock CrustomerCrudServiceImpl();
	
	public void testWithdraw() {
	//	Mockito.when(CustomerCrudServiceImpl.amount = 100)
	}

}
