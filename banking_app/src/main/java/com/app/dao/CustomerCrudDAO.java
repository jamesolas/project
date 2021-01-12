package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.TransactionRequests;
import com.app.model.Transactions;

public interface CustomerCrudDAO {
	
	public int createCustomer(Customer customer) throws BusinessException;
	public int createBalance(CustomerAccount customerAccount) throws BusinessException;
	public int deleteCustomer(Customer customer)throws BusinessException;
	
	public int deposit(CustomerAccount customerAccount) throws BusinessException;
	public int withdraw(CustomerAccount customerAccount) throws BusinessException;
	
	public int sendMoney(TransactionRequests transactionRequests) throws BusinessException;
	public int receiveMoney(int receivingAccount) throws BusinessException;
	
	public int updateTransactions(Transactions transactions) throws BusinessException;
	public int updateAccounts(Transactions transactions) throws BusinessException;
	
}
