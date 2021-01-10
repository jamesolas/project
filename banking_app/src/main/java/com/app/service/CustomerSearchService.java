package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;

public interface CustomerSearchService {
	
	//public Customer customerLogin(String customerEmail, String customerPassword) throws BusinessException;
	public Customer customerLogin(String customerEmail, String customerPassword) throws BusinessException;
	public CustomerAccount viewBalance(long customerId) throws BusinessException;
	public CustomerAccount deposit(long customerId) throws BusinessException;
	public CustomerAccount withdraw(long customerId) throws BusinessException;
	public CustomerAccount sendMoney(long customerId) throws BusinessException;
	public CustomerAccount receiveMoney(long customerId) throws BusinessException;
	public CustomerAccount viewIncoming(long custumerId) throws BusinessException;
	public String findCustomerId(String customerEmail) throws BusinessException;
	public long findAccountNumber(long customerId) throws BusinessException;
}
