package com.app.model;

import java.util.Date;

public class Customer {
	private long customerId;
	private String customerFirstName;
	private String customerLastName;
	private Date customerAge;
	private String customerEmail;
	private String customerPassword;
	private long accountNumber;
	private Date dob;
	
	
	
	public Customer(String customerFirstName, String customerLastName, String customerEmail, String customerPassword,
			Date dob) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.dob = dob;
	}

	public Customer(long customerId, String customerFirstName, String customerLastName, Date customerAge,
			String customerEmail, String customerPassword, long accountNumber, Date dob) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAge = customerAge;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.accountNumber = accountNumber;
		this.dob = dob;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public Date getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(Date customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + ((customerAge == null) ? 0 : customerAge.hashCode());
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + ((customerFirstName == null) ? 0 : customerFirstName.hashCode());
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + ((customerLastName == null) ? 0 : customerLastName.hashCode());
		result = prime * result + ((customerPassword == null) ? 0 : customerPassword.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (customerAge == null) {
			if (other.customerAge != null)
				return false;
		} else if (!customerAge.equals(other.customerAge))
			return false;
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
			return false;
		if (customerFirstName == null) {
			if (other.customerFirstName != null)
				return false;
		} else if (!customerFirstName.equals(other.customerFirstName))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerLastName == null) {
			if (other.customerLastName != null)
				return false;
		} else if (!customerLastName.equals(other.customerLastName))
			return false;
		if (customerPassword == null) {
			if (other.customerPassword != null)
				return false;
		} else if (!customerPassword.equals(other.customerPassword))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", customerAge=" + customerAge + ", customerEmail=" + customerEmail
				+ ", customerPassword=" + customerPassword + ", accountNumber=" + accountNumber + ", dob=" + dob + "]";
	}
	
	
	

}