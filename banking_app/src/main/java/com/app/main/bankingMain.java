package com.app.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.omg.CORBA.Environment;

import com.app.dao.impl.CustomerCrudDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.service.CustomerCrudService;
import com.app.service.impl.CustomerCrudServiceImpl;

public class bankingMain {
	private static Logger log = Logger.getLogger(bankingMain.class); 
	
	
	public static void main(String[] args) {
		CustomerCrudService customerCrudService = new CustomerCrudServiceImpl();
		CustomerCrudDAOImpl dao = new CustomerCrudDAOImpl(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = new Date();
		Scanner sc = new Scanner(System.in);
		log.info("Welcome to the banking app.");
		int ch = 0;
	
		do {
			log.info("Please select a choice.");
			log.info("1)Apply for a new account");
			log.info("2)Customer login");
			log.info("3)Employee Login");
			log.info("4)Exit");
			
			String customerFirstName=null;
			String customerLastName=null;
			String customerEmail=null;
			String customerPassword=null;
			Date customerDob=null;
			Date dob=null;
			Long accountBalance=null;
			
			try {
				//ch = Integer.parseInt(sc.nextLine());
				ch = sc.nextInt();
				sc.nextLine();
			}catch(NumberFormatException e) {}
			
			switch(ch) {
			case 1:log.info("Enter your first name."); 
			
			
				//try {
					
					customerFirstName = sc.nextLine();						
					//customerFirstName.length() > 0;
					//}catch(BusinessException e) {
					//	log.info(e.getMessage());
					//}
				try {
					log.info("Enter your last name.");
					customerLastName = sc.nextLine();
					
					Customer customer = customerCrudService.createCustomerLastName(customerLastName);
				}catch(BusinessException e) {
					log.info(e.getMessage());
				}
				
				try {
					
					log.info("Enter your email address.");
					customerEmail = sc.nextLine();
					Customer customer = customerCrudService.createCustomerEmail(customerEmail);
				}catch(BusinessException e) {
					log.info(e.getMessage());
				}
				
				try {
					
					log.info("Enter a password.");
					customerPassword = sc.nextLine();
					Customer customer = customerCrudService.createCustomerPassword(customerPassword);
				}catch(BusinessException e) {
					log.info(e.getMessage());
				}
				
				//try {
					
					
					//Customer customer = customerCrudService.createCustomerPassword(customerPassword);
				//}catch(BusinessException e) {
					//log.info(e.getMessage());
				//}
				
//				try {
//					//sc.nextLine();
//					log.info("Enter your date of birth.");
//					customerDob = sdf.parse(sc.nextLine());
//					log.info(customerDob);
//
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
				
					Customer customer = new Customer(customerFirstName, customerLastName, customerEmail, customerPassword, dob);
					
					try {
						if(dao.createCustomer(customer) != 0) {
							log.info("customer created successfully");
						}
					}catch(BusinessException e) {
						log.info(e.getMessage());
					}
					
					log.info("Enter a starting balance.");
					accountBalance = sc.nextLong();
					sc.nextLine();
					CustomerAccount customerAccount= new CustomerAccount(accountBalance);
					try {
						if(dao.createAccount(customerAccount) != 0){
							log.info("balance created successfully");
						}
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
					
					
			break;
			case 2:
			
			break;	
			case 3:
			
			break;
			case 4:
			
			break;
			default: log.info("Invalid menu option");
			break;	
			}
	}while(ch != 4);
}
}
