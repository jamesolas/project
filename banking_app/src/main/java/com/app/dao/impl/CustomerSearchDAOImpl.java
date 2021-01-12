package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerSearchDAO;
import com.app.dao.dbutil.PostresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.Employee;
import com.app.model.TransactionRequests;
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

	@Override
	public List<TransactionRequests> findReceiving(int accountNumber) throws BusinessException {
		List<TransactionRequests> transactionRequestsList = new ArrayList<>();
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql="select amount, date, sendingaccountnumber, receivingaccountnumber, requestid from project.transactionrequests where receivingaccountnumber=?";
			PreparedStatement preparedStatement  = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				TransactionRequests transactionRequests = new TransactionRequests();
				transactionRequests.setAmount(resultSet.getInt("amount"));
				transactionRequests.setDate(resultSet.getDate("date"));
				transactionRequests.setSendingAccount(resultSet.getLong("sendingaccountnumber"));
				transactionRequests.setReceivingAccount(resultSet.getLong("receivingaccountnumber"));
				transactionRequests.setRequestId(resultSet.getLong("requestid"));
				transactionRequestsList.add(transactionRequests);
			}
			if(transactionRequestsList.size() == 0){
				throw new BusinessException("No incoming money transfer found with account number " + accountNumber);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured. Contact SYSADMIN.");
		}
		return transactionRequestsList;
	}

	@Override
	public Employee employeeLogin(String email, String password) throws BusinessException {
		Employee employee = null;

		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "select employeeid, email, password from project.customer "
					+ "where email=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee = new Employee();
				employee.setEmployeeId(resultSet.getInt("employeeId"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPassword(resultSet.getString("password"));	
				
		}else {
			throw new BusinessException("Username and password do not match");
		}
		}catch(ClassNotFoundException | SQLException e){
			log.info(e);
			throw new BusinessException("Internal error occurred.");
		}
		return employee;
	}

	
	
	

}
