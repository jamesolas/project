package com.app.service.impl;

import com.app.dao.impl.CustomerCrudDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.TransactionRequests;
import com.app.model.Transactions;
import com.app.service.CustomerCrudService;

import java.util.Date;

import org.apache.log4j.Logger;

public class CustomerCrudServiceImpl implements CustomerCrudService {
	private static Logger log = Logger.getLogger(CustomerCrudServiceImpl.class); 
	
	CustomerCrudDAOImpl dao = new CustomerCrudDAOImpl(); 

	@Override
	public Customer createCustomer(String customerFirstName, String customerLastName, String customerEmail,
			String customerPassword, Date customerDob) throws BusinessException {
		Customer customer = null;
		//customer = customerCrudDAO.createCustomer(customerFirstName, customerLastName, customerEmail, customerPassword,);
		
		//code to DAO
		Customer c = new Customer(customerFirstName, customerLastName, customerEmail, customerPassword, customerDob);
		if(dao.createCustomer(c) != 0) {
			log.info("Customer created successfully.");
		}
		return customer;
	}
	
	@Override
	public CustomerAccount createBalance(long accountBalance) throws BusinessException {
		CustomerAccount customerAccount = null;
		//code to DAO
		CustomerAccount c = new CustomerAccount(accountBalance);
		try {
			if(dao.createBalance(c) != 0) {
				log.info("Balance created successfully.");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return customerAccount;
	}

	@Override
	public CustomerAccount deposit(long amount, long customerId) throws BusinessException {
		CustomerAccount customerAccount = null;
		//code to DAO
		CustomerAccount c = new CustomerAccount(amount, customerId);

		try {
			if(dao.deposit(c) != 0) {
				log.info("Deposit was successful.");
			}else {
				log.info("Deposit was not successful");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return customerAccount;
	}

	@Override
	public CustomerAccount withdraw(long amount, long customerId) throws BusinessException {
		CustomerAccount customerAccount = null;
		//code to DAO
		CustomerAccount c = new CustomerAccount(amount, customerId);
		try {
			if(dao.withdraw(c) != 0) {
				log.info("Withdrawal was successful.");
			}else {
				log.info("Deposit was not successful");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return customerAccount;
	}

	@Override
	public TransactionRequests sendMoney(long amount,long sendingAccountNumber, long receivingAccountNumber) throws BusinessException {
		TransactionRequests transactionRequests = null;
		//code to DAO
		TransactionRequests c = new TransactionRequests(amount, sendingAccountNumber, receivingAccountNumber);
		try {
			if(dao.sendMoney(c) != 0) {
				log.info("Sending money request was successful.");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return transactionRequests;
	}

	@Override
	public TransactionRequests receiveMoney(long receivingAccount) throws BusinessException {
		TransactionRequests  transactionRequests  = null;
		//code to DAO
	
		try {
			if(dao.receiveMoney((int)receivingAccount) != 0) {
				log.info("Money transfer was successful.");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return transactionRequests;
	}

	@Override
	public Customer deleteCustomer(long customerId) throws BusinessException {
		Customer customer = null;
		//code to DAO
		dao.deleteCustomer(customerId);
		return customer;
	}

	@Override
	public Transactions updateTransactions(long amount, long accountNumber) throws BusinessException {
		Transactions transactions = null;
		//code to DAO
		Transactions c = new Transactions(amount, accountNumber);
		try {
			if(dao.updateTransactions(c) != 0) {
				log.info("Updating the transactions log was successful.");
			}else {
				log.info("Updating transactions log was not successful.");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return transactions;
	}
	


	
	
}
