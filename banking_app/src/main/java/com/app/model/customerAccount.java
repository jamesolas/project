package com.app.model;

import java.time.LocalDateTime;
import java.util.Date;

public class CustomerAccount {
	private long accountNumber;
	private long customerId;
	private long accountBalance;
	private long amount;
	private LocalDateTime date;
	
	
	public CustomerAccount() {
	}

	public CustomerAccount(long accountNumber, long customerId, long accountBalance, long amount, LocalDateTime date) {
		super();
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.accountBalance = accountBalance;
		this.amount = amount;
		this.date = date;
	}

	public CustomerAccount(long accountNumber, long customerId, long accountBalance, long amount) {
		super();
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.accountBalance = accountBalance;
		this.amount = amount;
	}

	public CustomerAccount(long customerId, long accountBalance) {
		super();
		this.customerId = customerId;
		this.accountBalance = accountBalance;
	}

	public CustomerAccount(long accountBalance) {
		super();
		this.accountBalance = accountBalance;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountBalance ^ (accountBalance >>> 32));
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
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
		CustomerAccount other = (CustomerAccount) obj;
		if (accountBalance != other.accountBalance)
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (customerId != other.customerId)
			return false;
		return true;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CustomerAccount [accountNumber=" + accountNumber + ", customerId=" + customerId + ", accountBalance="
				+ accountBalance + ", amount=" + amount + ", date=" + date + "]";
	}

	

}
