package com.app.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import com.app.dao.CustomerCrudDAO;
import com.app.dao.dbutil.PostresqlConnection;
import com.app.exception.BusinessException;
import com.app.main.bankingMain;
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
				+" customerpassword) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getCustomerFirstName());
			preparedStatement.setString(2, customer.getCustomerLastName());
			preparedStatement.setString(3, customer.getCustomerEmail());
			preparedStatement.setString(4, customer.getCustomerPassword());
		
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
			String sql = "update project.account set accountbalance = accountbalance + ?";
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
	public int withdraw(CustomerAccount customerAccount) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "update project.account set accountbalance = accountbalance - ?";
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
		// TODO Auto-generated method stub
		return 0;
	}

	







}
