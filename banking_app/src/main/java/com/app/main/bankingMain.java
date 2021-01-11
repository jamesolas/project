package com.app.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;
import com.app.dao.CustomerSearchDAO;
import com.app.dao.impl.CustomerCrudDAOImpl;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.TransactionRequests;
import com.app.model.Transactions;
import com.app.service.CustomerCrudService;
import com.app.service.CustomerSearchService;
import com.app.service.impl.CustomerCrudServiceImpl;
import com.app.service.impl.CustomerSearchServiceImpl;

public class bankingMain {
	private static Logger log = Logger.getLogger(bankingMain.class); 
	
	
	public static void main(String[] args) {
		CustomerCrudService customerCrudService = new CustomerCrudServiceImpl();
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		log.info("Welcome to Bank of Java.");
		int ch = 0;
	
		do {
			log.info("Please select a choice.");
			log.info("1)Apply for a new account");
			log.info("2)Customer login");
			log.info("3)Employee Login");
			log.info("4)Exit");
			
			String findId = null;
			long findAccount = 0;
			String customerFirstName=null;
			String customerLastName=null;
			String customerEmail=null;
			String customerPassword=null;
			long accountBalance=0;
			long getBalance = 0;
			
			
			try {
				ch = sc.nextInt();
				sc.nextLine();
			}catch(NumberFormatException e) {
			}
			
			switch(ch) {
			case 1:log.info("Enter your first name."); 
							
					customerFirstName = sc.nextLine();
					if(customerFirstName.length() <= 0) {
						log.info("Please enter the customer's first name.");
					}
						
					log.info("Enter your last name.");
					customerLastName = sc.nextLine();
					if(customerLastName.length() <= 0) {
						log.info("Please enter the customer's last name.");
					}
									
					log.info("Enter your email address.");
					customerEmail = sc.nextLine();
					if(customerEmail.length() <= 0) {
						log.info("Please enter an email address.");
					}
					
					log.info("Enter a password.");
					customerPassword = sc.nextLine();
					if(customerPassword.length() <= 0) {
						log.info("Please enter a password.");
					}
					
					log.info("Enter your date of birth.");
					String dateInput = sc.nextLine();
					
					Date customerDob = null;			
					SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
					
					if(dateInput.matches("[0-9]{2}.[0-9]{2}.[0-9]{4}")){
						sdf.setLenient(false);
						
						try {
							customerDob = sdf.parse(dateInput);
						}catch(ParseException e) {
							System.out.println("invalid date");	
						}
					}else {
						log.info("Invalid date");
					}
					
				try {
					Customer customer = customerCrudService.createCustomer(customerFirstName, customerLastName, customerEmail, customerPassword, customerDob);
				} catch (BusinessException e1) {
					e1.printStackTrace();
				  }
					
					log.info("Enter a starting balance.");
					accountBalance = sc.nextLong();
					sc.nextLine();
					
					//code to service
				try {
					CustomerAccount customerAccount = customerCrudService.createBalance(accountBalance);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
					
					
			break;
			case 2:
					log.info("Customer Login");
					log.info("Enter your email.");
					String customerEmail2 = sc.nextLine();
					log.info("Enter your password");
					String customerPassword2 = sc.nextLine();
				
						int x = 0;
						//code to service for logging in
				Customer customer;
				try {
					customer = customerSearchService.customerLogin(customerEmail2, customerPassword2);
					log.info(customer);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
						//code to service for finding customer Id
				try {
					findId = customerSearchService.findCustomerId(customerEmail2);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						log.info("Customer Id: "+findId);
						
						Long longId = Long.parseLong(findId);
						//code to service for finding account number
				try {
					findAccount = customerSearchService.findAccountNumber(longId);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						log.info("Account Number: "+findAccount);
						
						Long longId2 = Long.parseLong(findId);
						//code to service
				try {
					getBalance = customerSearchService.findBalance(longId2);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				log.info("Balance: "+getBalance);
				
					long customerId = 0;
					long accountNumber = 0;
					int cm = 0;
					do {
					log.info("Customer Menu");
					log.info("1)View Balance");
					log.info("2)Deposit money");
					log.info("3)Withdraw money");
					log.info("4)Send money");
					log.info("5)Receive money");
					log.info("6)Exit");
					
					try {
						cm=Integer.parseInt(sc.nextLine());
					}catch(NumberFormatException e) {
					}
					switch(cm) {
					case 1: log.info("View Balance");
						if(getBalance != 0) {
							log.info("Balance is "+getBalance);
							log.info("\n");
						}
					
					break;
					case 2: log.info("Deposit Money");
					
					log.info("customerId = "+findId);
					log.info("account balance = "+getBalance);
					
					
					
					try {	log.info("Enter deposit amount.");
							long amount = Long.parseLong(sc.nextLine());
							long longFindId = Long.parseLong(findId);
							
							findAccount = customerSearchService.findAccountNumber(longFindId);
							
							if(amount <= 0) {
								log.info("Please enter an amount greater than zero.");
							}else {
							//code to service
							CustomerAccount customerAccount3 = customerCrudService.deposit(amount, longFindId);
							Transactions transactions = customerCrudService.updateTransactions(amount, findAccount);
								//code to update balance
								longId2 = Long.parseLong(findId);
								getBalance = customerSearchService.findBalance(longId2);
								log.info("New balance: "+getBalance);
							
							}
						}catch(NumberFormatException e) {
							System.out.println("Player Id cannot be white spaces, special characters, or symbols. It must be numeric.");
						}catch(BusinessException e) {
							System.out.println(e.getMessage());
						}
					
					break;
					case 3: log.info("Withdraw Money");
					try {
						log.info("Enter withdrawal amount.");
						long longFindId = Long.parseLong(findId);
						long amount = Long.parseLong(sc.nextLine());
						if(amount > getBalance) {
							log.info("You don't have that much money to withdraw.");
						}else {
						if (amount <= 0) {
							log.info("Please enter an amount greater than zero.");
						}else {
						CustomerAccount customerAccount3 = customerCrudService.withdraw(amount, longFindId);
						
							//code to update balance
							longId2 = Long.parseLong(findId);
							getBalance = customerSearchService.findBalance(longId2);
						}}
					}catch(NumberFormatException e) {
						System.out.println("Player Id cannot be white spaces, special characters, or symbols. It must be numeric.");
					}catch(BusinessException e) {
						System.out.println(e.getMessage());
					}
					
					break;
					case 4: log.info("Send money");
					try {
						//code to update balance
						longId2 = Long.parseLong(findId);
						getBalance = customerSearchService.findBalance(longId2);
						log.info(getBalance);
						
						log.info("Enter amount.");
						long amount = Long.parseLong(sc.nextLine());
						if(amount > getBalance) {
							log.info("You don't have that much money to withdraw.");
							}else {
								if (amount <= 0) {
							log.info("Please enter an amount greater than zero.");
									}else {
										log.info("Please enter an account number to send money to.");
										long receivingAccountNumber = Long.parseLong(sc.nextLine());
										if(receivingAccountNumber < 0) {
											log.info("Please enter a valid account number.");
											}else {
												TransactionRequests transactionRequests = customerCrudService.sendMoney(amount, findAccount, receivingAccountNumber);
												if(transactionRequests != null) {
													log.info("Request to send money was successful.");
													log.info(transactionRequests);
													
													//code to update balance
													longId2 = Long.parseLong(findId);
													//code to service
													getBalance = customerSearchService.findBalance(longId2);
											}
										}
								}
						}
					}catch(NumberFormatException e) {
						System.out.println("Player Id cannot be white spaces, special characters, or symbols. It must be numeric.");
					}catch(BusinessException e) {
						System.out.println(e.getMessage());
					}
					
					break;
					case 5: log.info("Receive money");
					
					break;
					case 6: log.info("Exit");
					}
					
					
					
					
					
					}while(cm != 6);
			
			break;	
			case 3:log.info("Employee Login");
			
			break;
			case 4:log.info("Exit");
			
			break;
			default: log.info("Invalid menu option");
			break;	
			}
	}while(ch != 4);
}
}
