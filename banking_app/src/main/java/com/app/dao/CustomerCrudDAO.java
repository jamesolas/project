package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.CustomerRequests;
import com.app.model.TransactionRequests;
import com.app.model.Transactions;

public interface CustomerCrudDAO {
	
	public int createCustomerRequest(CustomerRequests customerRequests) throws BusinessException;
	public int createBalance(CustomerAccount customerAccount) throws BusinessException;
	public void deleteCustomer(long customerId)throws BusinessException;
	
	public int deposit(CustomerAccount customerAccount) throws BusinessException;
	public int withdraw(CustomerAccount customerAccount) throws BusinessException;
	
	public int sendMoney(TransactionRequests transactionRequests) throws BusinessException;
	public int receiveMoney(int receivingAccount) throws BusinessException;
	
	public int updateTransactions(Transactions transactions) throws BusinessException;
	public int updateAccounts(Transactions transactions) throws BusinessException;
	
	public int insertTransaction(Transactions transactions) throws BusinessException;
	public int updateReceiver(CustomerAccount customerAccount) throws BusinessException;
	public int updateSender(CustomerAccount customerAccount) throws BusinessException;
	public long deleteTransactionRequest (long requestId) throws BusinessException;
	
	public int approveCustomer (long requestId) throws BusinessException;

	
}
