package com.app.main;

import java.lang.reflect.Array;
import java.nio.channels.ScatteringByteChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import com.app.dao.CustomerSearchDAO;
import com.app.dao.impl.CustomerCrudDAOImpl;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.CustomerRequests;
import com.app.model.Employee;
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
			
			Employee employee = null;
			Customer customer = null;
			String findId = null;
			long findAccount = 0;
			String customerFirstName=null;
			String customerLastName=null;
			String customerEmail=null;
			String customerEmail2=null;
			String customerPassword=null;
			long accountBalance=0;
			long getBalance = 0;
			long startingBalance = 0;
			
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
							
					Date customerDob = null;			
					SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
					sdf.setLenient(false);
					while (customerDob == null){
						log.info("Enter your date of birth.");
						String dateInput = sc.nextLine();
						if(dateInput.matches("[0-9]{2}.[0-9]{2}.[0-9]{4}")){				
						try {
							customerDob = sdf.parse(dateInput);
						}catch(ParseException e) {
							log.info("invalid date");	
						}
						}else {
						log.info("Invalid date");
						}
					}
					log.info("Enter a starting balance.");
					startingBalance = sc.nextLong();
					sc.nextLine();
					
				try {
					CustomerRequests createCustomer = customerCrudService.createCustomerRequest(customerFirstName, customerLastName, customerEmail, customerPassword, customerDob, startingBalance);
				} catch (BusinessException e1) {
					e1.printStackTrace();
				  }
					
					
			break;
			case 2: 
				while(customer == null) {
					log.info("Customer Login");
					log.info("Enter your email.");
					customerEmail2 = sc.nextLine();
					log.info("Enter your password");
					String customerPassword2 = sc.nextLine();			
						//code to service for logging in
				try {
					customer = customerSearchService.customerLogin(customerEmail2, customerPassword2);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				log.info(customer);
			
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
						Transactions transactions = customerCrudService.updateTransactions(amount, findAccount);
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
					case 5: 
						int cr = 0;
						
							do {
								
							log.info("Receive money");
							log.info("1)View incoming money transfers.");
							log.info("2)Accept an incoming money transfer.");
							log.info("3)Reject an incoming money transfer.");
							log.info("4)Exit");
							
							try {
								cr=Integer.parseInt(sc.nextLine());
								}catch(NumberFormatException e) {
								}
							
					switch(cr) {
						case 1:log.info("View incoming money transfers.");
						//code to update balance
						longId2 = Long.parseLong(findId);
						
						//code to get account number
						try {
							findAccount = customerSearchService.findAccountNumber(longId);
						} catch (BusinessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
								log.info("Account Number: "+findAccount);
						//code to service layer
						try {
							getBalance = customerSearchService.findBalance(longId2);
						} catch (BusinessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							List<TransactionRequests> transactionRequestsList = customerSearchService.findReceiving(findAccount);
							//code to print results
							if(transactionRequestsList != null && transactionRequestsList.size() > 0) {
								System.out.println("Incoming money transfers for account " + findAccount);
								for(TransactionRequests t:transactionRequestsList) {
									System.out.println(t);
								}
							}
						} catch (BusinessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
							
						break;
						case 2:log.info("Accept an incoming money transfer.");
							   log.info("Enter a transaction request Id to accept");
							   int requestId = Integer.parseInt(sc.nextLine());
							 //code to get account number
								try {
									findAccount = customerSearchService.findAccountNumber(longId);
								} catch (BusinessException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
										log.info("Account Number: "+findAccount);
							//code to service layer
						try {
							
							TransactionRequests transactionRequests = customerCrudService.receiveMoney(findAccount, requestId);
						} catch (BusinessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							   
						break;
						case 3:log.info("Reject an incoming money transfer.");
							int rejectTransferId = Integer.parseInt(sc.nextLine());
						try {
							TransactionRequests rejectTransfer = customerCrudService.deleteRequest(rejectTransferId);
						} catch (BusinessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						break;
						case 4:log.info("Exit");
						break;
						default: log.info("Invalid menu option");
					}
					}while(cr != 4);
					break;
					case 6: log.info("Exit");	
					}
					}while(cm != 6);
			
			break;	
			case 3:
				while(employee == null) {
				log.info("Employee Login");
				log.info("Enter your email.");
				String employeeEmail = sc.nextLine();
				log.info("Enter your password");
				String employeePassword = sc.nextLine();
		
				//code to service for logging in
				try {
					employee = customerSearchService.employeeLogin(employeeEmail, employeePassword);
				} catch (BusinessException e1) {
					e1.printStackTrace();
				  }
				}
				log.info(employee);
				int ce = 0;
				do {
					log.info("Employee Menu");
					log.info("1)View customers' balances");
					log.info("2)View all transactions");
					log.info("3)Delete a customer account");
					log.info("4)View new customer requests");
					log.info("5)Accept a new customer request");
					log.info("6)Reject a new customer request");
					log.info("7)Exit");
					
					
					try {
						ce=Integer.parseInt(sc.nextLine());
					}catch(NumberFormatException e) {
					}
					switch(ce) {
					case 1:log.info("View customers' balances");
						try {
							List<Customer>customerBalances = customerSearchService.viewCustomerBalances();
							if(customerBalances != null && customerBalances.size() > 0) {
								System.out.println("Showing all customer balances");
								for(Customer c:customerBalances) {
									System.out.println(c);
								}
							}
							}catch (BusinessException e){
								System.out.println(e.getMessage());
							}
						
					
					break;
					case 2:log.info("View all transactions");
					try {
						List<Transactions>transactionsList = customerSearchService.viewAllTransactions();
						if(transactionsList != null && transactionsList.size() > 0) {
							System.out.println("Showing all transactions");
							for(Transactions t:transactionsList) {
								System.out.println(t);
							}
						}
						}catch (BusinessException e){
							System.out.println(e.getMessage());
						}
					break;
					case 3:log.info("Delete a customer account");
						log.info("Enter a customer Id to delete.");
						customerId = Long.parseLong(sc.nextLine());
						try {
							customer = customerCrudService.deleteCustomer(customerId);
							log.info("Customer "+customerId+" deleted successfully.");
						} catch (BusinessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					break;
					case 4: log.info("4)View new customer requests");
						try {
							List<CustomerRequests> customerRequests = customerSearchService.viewCustomerRequests();
							if(customerRequests != null) {
								log.info(customerRequests);
							}
						} catch (BusinessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
						
					break;
					case 5: log.info("5)Accept a new customer request");
							log.info("Please enter a requestId to approve");
							int requestId = Integer.parseInt(sc.nextLine());
						try {
							CustomerRequests customerRequests = customerCrudService.approveCustomerRequest(requestId);
						} catch (BusinessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						  }
					
					break;
					case 6: log.info("6)Reject a new customer request");
						log.info("Please enter a requestId to reject");
						int requestId2 = Integer.parseInt(sc.nextLine());
						try {
							CustomerRequests customerRequests = customerCrudService.deleteCustomerRequest(requestId2);
						} catch (BusinessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					break;
					case 7: log.info("Exit");
					
					break;
					default: log.info("Invalid menu option");
					}
				}while(ce != 7);
		
			break;
			case 4:log.info("Exit");
			
			break;
			default: log.info("Invalid menu option");
			break;	
			}
	}while(ch != 4);
}
}
