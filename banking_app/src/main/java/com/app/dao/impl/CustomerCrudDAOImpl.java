package com.app.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.CustomerCrudDAO;
import com.app.dao.dbutil.PostresqlConnection;
import com.app.exception.BusinessException;
import com.app.main.bankingMain;
import com.app.model.Customer;
import com.app.model.CustomerAccount;

public class CustomerCrudDAOImpl implements CustomerCrudDAO {
	
	private static Logger log = Logger.getLogger(CustomerCrudDAOImpl.class);

	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "insert into project.customer(customerfirstname, customerlastname, customeremail,"
				+" customerpassword) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getCustomerFirstName());
			preparedStatement.setString(2, customer.getCustomerLastName());
			//Date date = Date.valueOf(String.valueOf(customer.getDob()));
			//Date date = Date.valueOf(
			preparedStatement.setString(3, customer.getCustomerEmail());
			preparedStatement.setString(4, customer.getCustomerPassword());
			//preparedStatement.setDate(5, (java.sql.Date) customer.getDob());
		
			c = preparedStatement.executeUpdate();
		
		}catch(ClassNotFoundException | SQLException e){
			log.info(e);
			throw new BusinessException("Internal error occured. Please contact admin.");
		}
		return c;
	}
	
	public int createAccount(CustomerAccount customerAccount) throws BusinessException{
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
	public Customer createAccountBalance(long accountBalance) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Customer createCustomerFirstName(String customerFirstName) throws BusinessException {
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
