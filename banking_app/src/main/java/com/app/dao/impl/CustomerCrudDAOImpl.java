package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.app.dao.CustomerCrudDAO;
import com.app.dao.dbutil.PostresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.TransactionRequests;
import com.app.model.Transactions;

public class CustomerCrudDAOImpl implements CustomerCrudDAO {
	
	private static Logger log = Logger.getLogger(CustomerCrudDAOImpl.class);
	
	Transactions transactions = new Transactions();
	
	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "insert into project.customer(customerfirstname, customerlastname, customeremail,"
				+" customerpassword, dob) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getCustomerFirstName());
			preparedStatement.setString(2, customer.getCustomerLastName());
			preparedStatement.setString(3, customer.getCustomerEmail());
			preparedStatement.setString(4, customer.getCustomerPassword());
			preparedStatement.setDate(5, new java.sql.Date(customer.getCustomerDob().getTime()));
			//preparedStatement.setDate(5,java.sql.Date.valueOf(java.time.LocalDate.now()));
			c = preparedStatement.executeUpdate();
		
		}catch(ClassNotFoundException | SQLException e){
			log.info(e);
			throw new BusinessException("Internal error occured. Please contact admin.");
		}
		return c;
	}
	
	public int createBalance(CustomerAccount customerAccount) throws BusinessException{
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "insert into project.account(accountbalance) values(?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerAccount.getAccountBalance());
			
			c = preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Inernal error occured. Please contact admin.");
		}
		return c;
	}

	@Override
	public int deleteCustomer(Customer customer) throws BusinessException{
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "delete from project.customer(customerid) values(?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customer.getCustomerId());
			
			c = preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Inernal error occured. Please contact admin.");
		}
		return c;
	}
	
	
	@Override
	public int deposit(CustomerAccount customerAccount) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "update project.account set accountbalance = accountbalance + ? where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerAccount.getAmount());
			preparedStatement.setLong(2, customerAccount.getCustomerId());
			
			
			
			c = preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Internal error occured. Please contact admin.");
		}
		return c;
	}

	@Override
	public int withdraw(CustomerAccount customerAccount) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "update project.account set accountbalance = accountbalance - ? where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerAccount.getAmount());
			preparedStatement.setLong(2, customerAccount.getCustomerId());
			
			c = preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Inernal error occured. Please contact admin.");
		}
		return c;
	}
	
	
	@Override
	public int sendMoney(TransactionRequests transactionRequests) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "insert into project.transactionrequests (amount, date, sendingaccountnumber, receivingaccountnumber) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, transactionRequests.getAmount());
			preparedStatement.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			preparedStatement.setLong(3, transactionRequests.getSendingAccount());
			preparedStatement.setLong(4, transactionRequests.getReceivingAccount());
			
			c = preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Inernal error occured. Please contact admin.");
		}
		return c;
	}

	@Override
	public int receiveMoney(CustomerAccount customerAccount) throws BusinessException {
		int c = 0;
		
		
		
		
		
		return c;
	}

	@Override
	public int updateTransactions(Transactions transactions) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
		String sql = "insert into project.transactions (date, amount, accountnumber) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		//preparedStatement.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
		Date date = null;
		preparedStatement.setDate(1, new java.sql.Date (Transactions.getDate().getTime()));
		preparedStatement.setLong(2, transactions.getAmount());
		preparedStatement.setLong(3, transactions.getAccountNumber());
		
		log.info("date: "+java.sql.Date.valueOf(java.time.LocalDate.now()));
		log.info("getAmount: "+transactions.getAmount());
		log.info("getAccountNumber: "+transactions.getAccountNumber());
		
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Inernal error occured. Please contact admin.");
		}
		return c;
	}

	@Override
	public int updateAccounts(Transactions transactions) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	







}
