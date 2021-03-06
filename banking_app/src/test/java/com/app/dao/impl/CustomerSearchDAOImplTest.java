package com.app.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.sql.SQLData;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;

class CustomerSearchDAOImplTest {

	private static CustomerSearchDAOImpl test;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		test = new CustomerSearchDAOImpl();
	}

//	@Test
//	void testCustomerLogin() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testViewBalance() throws BusinessException {
//		long customerId = 9;
//		assertEquals(customerId, test.viewBalance(1));
//	}

	@Test
	void testFindCustomerId() throws BusinessException {
		long customerId = 1;
		assertEquals(customerId, test.findCustomerId("email"));
	}

	@Test
	void testFindAccountNumber() throws BusinessException {
			long accountNumber = 9;
			long customerId = 1;
		assertEquals(accountNumber, test.findAccountNumber(customerId));
	}

	@Test
	void testFindBalance() throws BusinessException {
		long balance = 3841;
		long customerId = 1;
		assertEquals(balance, test.findBalance(customerId));
	}

	@Test
	void testGetSendingAccount() throws BusinessException {
		long transactionId = 19;
		long senderAccountNumber = 10;
		assertEquals(senderAccountNumber, test.getSendingAccount(transactionId));
	}
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
//
	@Test
	void testGetSenderId() throws BusinessException {
		long customerId = 1;
		long sendingAccountNumber = 9;
		assertEquals(customerId, test.getSenderId(sendingAccountNumber));
	}

	@Test
	void testGetAmount() throws BusinessException {
		long requestId = 8;
		long amount = 100;
		assertEquals(amount, test.getAmount(requestId));
	}

	@Test
	void testGetDate() throws ParseException, BusinessException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = sdf.parse("2021-01-13");
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		long receivingAccountNumber = 1;
		//assertEquals(sqlDate, test.getDate(receivingAccountNumber));
		assertEquals(1, date.compareTo(test.getDate(receivingAccountNumber)));
		
	}

	@Test
	void testGetReceiverId() throws BusinessException {
		long receiverId = 1;
		long receivingAccountNumber = 9;
		assertEquals(receiverId, test.getReceiverId(receivingAccountNumber));
	}

	@Test
	void testGetSenderAccount() throws BusinessException {
		long requestId = 8;
		long senderAccount = 10;
		assertEquals(senderAccount, test.getSenderAccount(requestId));
	}

//	@Test
//	void testObject() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetClass() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testHashCode() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testEquals() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testClone() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testToString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testNotify() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testNotifyAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testWaitLong() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testWaitLongInt() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testWait() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFinalize() {
//		fail("Not yet implemented");
//	}

}
