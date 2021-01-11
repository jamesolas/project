package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.CustomerSearchDAO;
import com.app.dao.dbutil.PostresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.service.impl.CustomerSearchServiceImpl;

public class CustomerSearchDAOImpl implements CustomerSearchDAO {
	
	private static Logger log = Logger.getLogger(CustomerSearchServiceImpl.class);
	
	@Override
	public Customer customerLogin(String customerEmail, String customerPassword) throws BusinessException {
		Customer customer = null;

		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "select customeremail, customerpassword, customerid from project.customer "
					+ "where customeremail=? and customerpassword=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerEmail);
			preparedStatement.setString(2, customerPassword);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer = new Customer();
				customer.setCustomerEmail(customerEmail);
				customer.setCustomerPassword(customerPassword);	
				customer.setCustomerId(resultSet.getLong("customerid"));
		}else {
			throw new BusinessException("Username and password do not match");
		}
		}catch(ClassNotFoundException | SQLException e){
			log.info(e);
			throw new BusinessException("Internal error occurred.");
		}
		return customer;
	}

	@Override
	public CustomerAccount viewBalance(long customerId) throws BusinessException {
		CustomerAccount customerAccount = null;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "select accountnumber, accountbalance from project.account where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customerAccount = new CustomerAccount();
				customerAccount.setCustomerId(customerId);
				customerAccount.setAccountNumber(resultSet.getLong("accountNumber"));
				customerAccount.setAccountBalance(resultSet.getLong("accountbalance"));
			}else {
				throw new BusinessException("No account balance.");
			}	
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred.");
		}
		
		return customerAccount;
	}

	@Override
	public long findCustomerId(String customerEmail) throws BusinessException {
		long customerId;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "select customerid from project.customer where customeremail = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerEmail);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customerId = resultSet.getLong("customerid");
				
				
			}else {
				throw new BusinessException("No account balance.");
			}	
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred.");
		}
		
		return customerId;
	}

	@Override
	public long findAccountNumber(long customerId) throws BusinessException {
		long accountNumber;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "select accountnumber from project.account where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				accountNumber = resultSet.getLong("accountnumber");
				
				
			}else {
				throw new BusinessException("No account balance.");
			}	
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred.");
		}
		
		return accountNumber;
	}

	@Override
	public long findBalance(long customerId) throws BusinessException {
		long balance;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "select accountbalance from project.account where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				balance = resultSet.getLong("accountbalance");	
			}else {
				throw new BusinessException("No account balance.");
			}	
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred.");
		}
		
		return balance;
	}

	@Override
	public long getSendingAccount(long transactionId) throws BusinessException {
		long balance;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "select sendingaccount from project.transactions where transactionid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, transactionId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				balance = resultSet.getLong("accountbalance");	
			}else {
				throw new BusinessException("No account balance.");
			}	
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred.");
		}
		
		return balance;
	}


	
	

}
