package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;

public interface CustomerSearchDAO {
	
	public Customer customerLogin(String customerEmail, String customerPassword) throws BusinessException;
	public CustomerAccount viewBalance(long customerId) throws BusinessException;
	public long findCustomerId(String customerEmail) throws BusinessException;
	public long findAccountNumber(long customerId) throws BusinessException;
	public long findBalance(long customerId) throws BusinessException;
	public long getSendingAccount (long transactionId) throws BusinessException;
}
