package com.app.service.impl;

import com.app.dao.impl.CustomerCrudDAOImpl;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.CustomerRequests;
import com.app.model.TransactionRequests;
import com.app.model.Transactions;
import com.app.service.CustomerCrudService;


import java.util.Date;

import org.apache.log4j.Logger;

public class CustomerCrudServiceImpl implements CustomerCrudService {
	
	private static Logger log = Logger.getLogger(CustomerCrudServiceImpl.class); 
	
	CustomerCrudDAOImpl dao = new CustomerCrudDAOImpl(); 
	CustomerSearchDAOImpl dao2 = new CustomerSearchDAOImpl();

	
	
	@Override
	public CustomerRequests createCustomerRequest(String customerFirstName, String customerLastName, String customerEmail,
			String customerPassword, Date customerDob, long startingBalance) throws BusinessException {
		//code to DAO
		CustomerRequests c = new CustomerRequests(customerFirstName, customerLastName, customerEmail, customerPassword, customerDob, startingBalance);
		if(dao.createCustomerRequest(c) != 0) {
			log.info("Customer created successfully.");
		}
		return c;
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
		customerAccount = new CustomerAccount(amount, customerId);

		try {
			if(dao.deposit(customerAccount) != 0) {
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
	public TransactionRequests receiveMoney(long receivingAccount, long requestId) throws BusinessException {
		TransactionRequests  transactionRequests  = null;
		//long customerId =0;
		long sendingAccountNumber =0;
		long receivingAccountNumber = 0;
		
		//code to DAO
		try {
			//get information from database
			long customerId = dao2.getReceiverId (receivingAccount);
			long senderAccount = dao2.getSenderAccount(requestId);
			long senderCustomerId = dao2.getSenderId (senderAccount);
			long amount = dao2.getAmount (requestId);

			
			log.info("Service layer -> senderAccount: " + senderAccount);
			log.info("Service layer -> receivingAccount: " + receivingAccount);
			
			//insert information into database
			
			//insert into transactions
			Transactions transactions = new Transactions(amount, senderAccount, receivingAccount);
			dao.insertTransaction(transactions);
			
			//update sender balance
			CustomerAccount customerAccount = new CustomerAccount(amount,senderCustomerId);
			dao.updateSender(customerAccount);
			
			//update receiver balance
			CustomerAccount customerAccount2 = new CustomerAccount(amount,customerId);
			dao.updateReceiver(customerAccount2);
			
			//delete transactionrequest
			dao.deleteTransactionRequest(requestId);
			
//			if(dao.receiveMoney((int)receivingAccount) != 0) {
//				log.info("Money transfer was successful.");
//			}
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

	@Override
	public TransactionRequests deleteRequest(int requestId) throws BusinessException {
		TransactionRequests transactionRequests = null;
		try {
			if(dao.deleteTransactionRequest(requestId) != 0){
				log.info("Transaction request " + requestId + " successfully deleted");
			}else {
				log.info("Deleting transaction request " + requestId + " was not successful");
			}
		}catch(BusinessException e) {
			log.info(e.getMessage());
		}
			
			return transactionRequests;
	}

	@Override
	public CustomerRequests approveCustomerRequest(long requestId) throws BusinessException {
		CustomerRequests customerRequests = null;
		try {
			if(dao.approveCustomer(requestId) != 0) {
				log.info("Customer request has been approved");
			}else {
				log.info("Customer request approval was not successful");
			}
//			if(dao.deleteCustomerRequest(requestId) != 0) {
//				log.info("Customer request deletion has been approved");
//			}else {
//				log.info("Customer request deletion was not successful");
//			}
		}catch(BusinessException e) {
			log.info(e.getMessage());
		}
		return customerRequests;
	}

	@Override
	public CustomerRequests deleteCustomerRequest(long requestId) throws BusinessException {
		CustomerRequests customerRequests = null;
		try {
			if(dao.deleteCustomerRequest(requestId) == 0) {
				log.info("Customer request " + requestId + " successfully deleted");
			}else {
				log.info("Customer request " + requestId + " was not successfully deleted");
			}
		}catch(BusinessException e) {
			log.info(e.getMessage());
		}
		return customerRequests;
	}
	


	
	
}
