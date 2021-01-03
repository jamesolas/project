package com.app.service.impl;

import com.app.dao.CustomerCrudDAO;
import com.app.dao.impl.CustomerCrudDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerCrudService;

public class CustomerCrudServiceImpl implements CustomerCrudService {

	private CustomerCrudDAO customerCrudDAO = new CustomerCrudDAOImpl();

	@Override
	public Customer createCustomerFirstName(String customerFirstName) throws BusinessException {
		Customer customer = null;
		if(customerFirstName.length() > 0 && customerFirstName.length() < 10) {
			customer = customerCrudDAO.createCustomerFirstName(customerFirstName);
		}
		
		return customer;
	}

	@Override
	public Customer createCustomer(String customerFisrtName, String customerLastName, String customerEmail,
			String customerPassword, long accountNumber, String dob) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createCustomerLastName(String customerLastName) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createCustomerEmail(String customerEmail) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createCustomerPassword(String customerPassword) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createCustomerDob(String dob) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
