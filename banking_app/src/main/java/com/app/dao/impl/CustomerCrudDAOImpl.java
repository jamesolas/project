package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.app.dao.CustomerCrudDAO;
import com.app.dao.dbutil.PostresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.CustomerRequests;
import com.app.model.TransactionRequests;
import com.app.model.Transactions;

public class CustomerCrudDAOImpl implements CustomerCrudDAO {
	
	private static Logger log = Logger.getLogger(CustomerCrudDAOImpl.class);
	
	Transactions transactions = new Transactions();
	
	@Override
	public int createCustomerRequest(CustomerRequests customerRequests) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "insert into project.newcustomerrequest(customerfirstname, customerlastname, customeremail,"
				+" customerpassword, dob, accountbalance) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerRequests.getCustomerFirstName());
			preparedStatement.setString(2, customerRequests.getCustomerLastName());
			preparedStatement.setString(3, customerRequests.getCustomerEmail());
			preparedStatement.setString(4, customerRequests.getCustomerPassword());
			preparedStatement.setDate(5, new java.sql.Date(customerRequests.getCustomerDob().getTime()));
			preparedStatement.setLong(6, customerRequests.getAccountBalance());
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
	public void deleteCustomer(long customerId) throws BusinessException{
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "delete from project.customer where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerId);
			
			c = preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Inernal error occured. Please contact admin.");
		}
	}
	
	
	@Override
	public int deposit(CustomerAccount customerAccount) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "update project.account set accountbalance = accountbalance + ? where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerAccount.getAmount());
			preparedStatement.setLong(2, customerAccount.getCustomerId());
			
			log.info("deposit -> customerAccount.getCustomerId() " + customerAccount.getCustomerId());
			
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
	public int receiveMoney(int receivingAccount) throws BusinessException {
		int c = 0;
		int d = 0;
		int f = 0;
	
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "select amount, date, sendingaccountnumber, receivingaccountnumber, requestid from project.transactionrequests where receivingaccountnumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, receivingAccount);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				TransactionRequests transactionRequests = new TransactionRequests();
				transactionRequests.setAmount(resultSet.getInt("amount"));
				transactionRequests.setDate(resultSet.getDate("date"));
				transactionRequests.setSendingAccount(resultSet.getLong("sendingaccountnumber"));
				transactionRequests.setReceivingAccount(resultSet.getLong("receivingaccountnumber"));
				transactionRequests.setRequestId(resultSet.getLong("requestid"));
				c = preparedStatement.executeUpdate();
				
//				long amount = transactionRequests.getAmount();
//				log.info("amount "+amount);
//				Date date = transactionRequests.getDate();
//				log.info("date "+date);
//				long sendingAccount = transactionRequests.getSendingAccount();
//				log.info("sending account "+sendingAccount);
//				//receiving account already found from parameter
//				log.info("receiving account "+receivingAccount);
//				long requestId = transactionRequests.getRequestId();
//				log.info("request Id "+requestId);
				
				//code to get customer id
				if (c != 0) {
					String sql2 = "select customertid from project.customer where accountnumber = ?";
					PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
					preparedStatement2.setLong(1, transactionRequests.getSendingAccount());
					ResultSet resultSet2 = preparedStatement2.executeQuery();
					if(resultSet2.next()){
						Customer customer = new Customer();
						customer.setCustomerId(resultSet2.getInt("customerid"));
						
						long customerId = customer.getCustomerId();
						log.info("customer Id: "+customerId);			
					}
						
						d = preparedStatement.executeUpdate();
						
						//code to insert data into transactions table
						if (d != 0) {
							String sql3 = "insert into project.transactions values(date, amount, sendingaccountnumber, receivingaccountnumber)"
									+ "values(?,?,?,?)";
							PreparedStatement preparedStatement3 = connection.prepareStatement(sql2);
							preparedStatement3.setDate(1, new java.sql.Date(transactionRequests.getDate().getTime()));
							preparedStatement3.setLong(2, transactionRequests.getAmount());
							preparedStatement3.setLong(3, transactionRequests.getSendingAccount());
							preparedStatement3.setLong(4, transactionRequests.getSendingAccount());
							ResultSet resultSet3 = preparedStatement3.executeQuery();
							f = preparedStatement.executeUpdate();
						}											
					
				}
				}else {
				throw new BusinessException("No incoming money transfer found with account number " + receivingAccount);
			}
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Inernal error occured. Please contact admin.");
		}
		return f;
	}

	@Override
	public int updateTransactions(Transactions transactions) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
		String sql = "insert into project.transactions (date, amount, accountnumber) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
		preparedStatement.setLong(2, transactions.getAmount());
		preparedStatement.setLong(3, transactions.getAccountNumber());
		
		c = preparedStatement.executeUpdate();
		
		log.info("getAmount: "+transactions.getAmount());
		log.info("getAccountNumber: "+transactions.getAccountNumber());
		
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Internal error occured. Please contact admin.");
		}
		return c;
	}

	@Override
	public int updateAccounts(Transactions transactions) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
		String sql = "insert into project.transactions (date, amount, accountnumber) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
		preparedStatement.setLong(2, transactions.getAmount());
		preparedStatement.setLong(3, transactions.getAccountNumber());
		
		c = preparedStatement.executeUpdate();
		
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Internal error occured. Please contact admin.");
		}
		return c;
	}

	@Override
	public int insertTransaction(Transactions transactions) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
		String sql = "insert into project.transactions (date, amount, sendingaccountnumber, receivingaccountnumber) values(?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
		preparedStatement.setLong(2, transactions.getAmount());
		preparedStatement.setLong(3, transactions.getSendingAccountNumber());
		preparedStatement.setLong(4, transactions.getReceivingAccountNumber());
		
		log.info("insert transaction log");
		c = preparedStatement.executeUpdate();
		
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Internal error occured. Please contact admin.");
		}
		return c;
	}

	@Override
	public int updateReceiver(CustomerAccount customerAccount) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "update project.account set accountbalance = accountbalance + ? where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerAccount.getAmount());
			preparedStatement.setLong(2, customerAccount.getCustomerId());
			
			log.info("updateReceiver -> getAmount() " + customerAccount.getAmount());
			log.info("updateReceiver -> getAccountNumber() = " + customerAccount.getCustomerId());
			c = preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Internal error occured. Please contact admin.");
		}
		return c;
	}

	@Override
	public int updateSender(CustomerAccount customerAccount) throws BusinessException {
		int c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "update project.account set accountbalance = accountbalance - ? where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerAccount.getAmount());
			preparedStatement.setLong(2, customerAccount.getCustomerId());
			
			log.info("updateSender -> getAmount() " + customerAccount.getAmount());
			log.info("updateSender -> getAccountNumber() = " + customerAccount.getCustomerId());
			c = preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Internal error occured. Please contact admin.");
		}
		return c;
	}

	@Override
	public long deleteTransactionRequest(long requestId) throws BusinessException {
		long c = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "delete from project.transactionrequests where requestid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//Customer customer = new Customer();
			preparedStatement.setLong(1, requestId);
			
			c = preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);;
			throw new BusinessException("Inernal error occured. Please contact admin.");
		}
		return c;
	}

	public int approveCustomer (long requestId) throws BusinessException {
		int c = 0;
		int d = 0;
		int f = 0;
		
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "insert into project.customer(customerfirstname, customerlastname, customeremail, customerpassword, dob) "
					+ "select customerfirstname, customerlastname, customeremail, customerpassword, dob "
					+ "from project.newcustomerrequest where requestid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, requestId);
			c = preparedStatement.executeUpdate();
			
			if(c != 0) {
				String sql2 = "insert into project.account (accountbalance) select accountbalance from project.newcustomerrequest where requestid = ?";
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				preparedStatement2.setLong(1, requestId);
				d = preparedStatement2.executeUpdate();
			}
			
			if(d != 0) {
				String sql3 = "delete from project.newcustomerrequest where requestid = ?";
				PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
				preparedStatement3.setLong(1, requestId);
				f = preparedStatement3.executeUpdate();
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
		
	public int deleteCustomerRequest (long requestId) throws BusinessException {
		int c = 0;
		try( Connection connection = PostresqlConnection.getConnection()){
			String sql = "delete from project.newcustomerrequest where requestid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, requestId);
			c = preparedStatement.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}




}
