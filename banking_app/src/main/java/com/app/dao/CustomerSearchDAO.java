package com.app.dao;

import java.util.Date;
import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.CustomerRequests;
import com.app.model.Employee;
import com.app.model.TransactionRequests;
import com.app.model.Transactions;

public interface CustomerSearchDAO {
	
	public Customer customerLogin(String customerEmail, String customerPassword) throws BusinessException;
	public CustomerAccount viewBalance(long customerId) throws BusinessException;
	public long findCustomerId(String customerEmail) throws BusinessException;
	public long findAccountNumber(long customerId) throws BusinessException;
	public long findBalance(long customerId) throws BusinessException;
	public long getSendingAccount (long transactionId) throws BusinessException;
	public List<TransactionRequests> findReceiving (int accountNumber) throws BusinessException;
	public Employee employeeLogin(String employeeEmail, String employeePassword) throws BusinessException;
	
	public List<Customer>viewCustomerBalances() throws BusinessException;
	public List<Transactions>viewAllTransactions() throws BusinessException;
	
	public long getSenderAccount (long requestId) throws BusinessException;
	public long getSenderId (long sendingAccountNumber) throws BusinessException;
	public long getAmount (long receivingAccountNumber) throws BusinessException;
	public Date getDate (long receivingAccountNumber) throws BusinessException;
	public long getReceiverId (long receivingAccountNumber) throws BusinessException;
	
	public List<CustomerRequests> viewCustomerRequests() throws BusinessException;
	
	
	
}
