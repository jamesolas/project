package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerCrudService {
	public Customer createCustomer(String customerFisrtName,String customerLastName,String customerEmail,
			String customerPassword,long accountNumber,String dob) throws BusinessException;
	public Customer createCustomerFirstName(String customerFirstName) throws BusinessException;
	public Customer createCustomerLastName(String customerLastName) throws BusinessException;
	public Customer createCustomerEmail(String customerEmail) throws BusinessException;
	public Customer createCustomerPassword(String customerPassword) throws BusinessException;
	public Customer createCustomerDob(String dob) throws BusinessException;
}