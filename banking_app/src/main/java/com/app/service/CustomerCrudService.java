package com.app.service;

import java.util.Date;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.CustomerRequests;
import com.app.model.TransactionRequests;
import com.app.model.Transactions;

public interface CustomerCrudService {
	
	public CustomerRequests createCustomerRequest(String customerFirstName, String customerLastName, String customerEmail,
			String customerPassword, Date customerDob, long startingBalance) throws BusinessException;
	public Customer deleteCustomer(long customerId) throws BusinessException;
	public CustomerAccount createBalance(long accountBalance) throws BusinessException;
	
	public CustomerAccount deposit(long amount, long accountId) throws BusinessException;
	public CustomerAccount withdraw(long amount, long accountId) throws BusinessException;
	
	public TransactionRequests sendMoney(long amount, long sendingAccountNumber, long receivingAccountNumber) throws BusinessException;
	public TransactionRequests receiveMoney(long receivingAccount, long requestId) throws BusinessException;
	
	public Transactions updateTransactions (long amount, long accountNumber) throws BusinessException;
	public TransactionRequests deleteRequest (int requestId) throws BusinessException;
	
	public CustomerRequests approveCustomerRequest (long requestId) throws BusinessException;
	public CustomerRequests deleteCustomerRequest (long requestId) throws BusinessException;

}
