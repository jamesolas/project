package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.CustomerRequests;
import com.app.model.Employee;
import com.app.model.TransactionRequests;
import com.app.model.Transactions;

public interface CustomerSearchService {
	
	public Customer customerLogin(String customerEmail, String customerPassword) throws BusinessException;
	public CustomerAccount viewBalance(long customerId) throws BusinessException;
	
	public String findCustomerId(String customerEmail) throws BusinessException;
	public long findAccountNumber(long customerId) throws BusinessException;
	public long findBalance(long customerId) throws BusinessException;
	public List<TransactionRequests> findReceiving(long receivingAccount) throws BusinessException;
	
	public Employee employeeLogin(String employeeEmail, String employeePassword) throws BusinessException;
	
	public List<Customer>viewCustomerBalances() throws BusinessException;
	public List<Transactions>viewAllTransactions() throws BusinessException;
	
	public List<CustomerRequests>viewCustomerRequests() throws BusinessException;
	
	//public long findSenderId(long sendingAccountNumber) throws BusinessException;
	//public long findReceiverId(long receiverAccountNumber) throws BusinessException;
	
}
