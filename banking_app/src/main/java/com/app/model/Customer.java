package com.app.model;

import java.util.Date;

public class Customer {
	private long customerId;
	private String customerFirstName;
	private String customerLastName;
	private Date customerAge;
	private String customerEmail;
	private String customerPassword;
	private Date customerDob;
	
	public Customer() {	
	}

	public Customer(String customerFirstName, String customerLastName, String customerEmail, String customerPassword) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}

	public Customer(String customerFirstName, String customerLastName, String customerEmail, String customerPassword,
			Date customerDob) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerDob = customerDob;
	}


	public Customer(String customerFirstName, String customerLastName, Date customerAge, String customerEmail,
			String customerPassword) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAge = customerAge;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}

	public Customer(long customerId, String customerFirstName, String customerLastName, Date customerAge,
			String customerEmail, String customerPassword) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAge = customerAge;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}

	public Customer(long customerId) {
		super();
		this.customerId = customerId;
	}

	public Customer(String customerEmail, String customerPassword) {
		super();
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerAge == null) ? 0 : customerAge.hashCode());
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + ((customerFirstName == null) ? 0 : customerFirstName.hashCode());
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + ((customerLastName == null) ? 0 : customerLastName.hashCode());
		result = prime * result + ((customerPassword == null) ? 0 : customerPassword.hashCode());
	
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
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
		return false;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", customerAge=" + customerAge + ", customerEmail=" + customerEmail
				+ ", customerPassword=" + customerPassword + "]";
	}

	public Date getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}

	


}
