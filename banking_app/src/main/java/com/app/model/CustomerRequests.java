package com.app.model;

import java.util.Date;

public class CustomerRequests {
	
	private long requestId;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	private String customerPassword;
	private Date customerDob;
	private long AccountBalance;
	
	
	public CustomerRequests() {
		super();
	}

	public CustomerRequests(String customerFirstName, String customerLastName, String customerEmail,
			String customerPassword, Date customerDob, long accountBalance) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerDob = customerDob;
		AccountBalance = accountBalance;
	}


	public long getRequestId() {
		return requestId;
	}


	public void setRequestId(long requestId) {
		this.requestId = requestId;
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


	public Date getCustomerDob() {
		return customerDob;
	}


	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}


	public long getAccountBalance() {
		return AccountBalance;
	}


	public void setAccountBalance(long accountBalance) {
		AccountBalance = accountBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (AccountBalance ^ (AccountBalance >>> 32));
		result = prime * result + ((customerDob == null) ? 0 : customerDob.hashCode());
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + ((customerFirstName == null) ? 0 : customerFirstName.hashCode());
		result = prime * result + (int) (requestId ^ (requestId >>> 32));
		result = prime * result + ((customerLastName == null) ? 0 : customerLastName.hashCode());
		result = prime * result + ((customerPassword == null) ? 0 : customerPassword.hashCode());
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
		CustomerRequests other = (CustomerRequests) obj;
		if (AccountBalance != other.AccountBalance)
			return false;
		if (customerDob == null) {
			if (other.customerDob != null)
				return false;
		} else if (!customerDob.equals(other.customerDob))
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
		if (requestId != other.requestId)
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
		return true;
	}


	@Override
	public String toString() {
		return "CustomerRequests [requestId=" + requestId + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", customerEmail="
				+ customerEmail + ", customerPassword=" + customerPassword + ", customerDob=" + customerDob
				+ ", AccountBalance=" + AccountBalance + "]";
	}
	
	

}
