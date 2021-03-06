package com.app.model;

import java.util.Date;

public class Transactions {
	private long transactionId;
	private Date date;
	private long amount;
	private long sendingAccountNumber;
	private long receivingAccountNumber;
	private long accountNumber;
	
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}


	public Transactions(long transactionId, Date date, long amount, long sendingAccountNumber,
			long receivingAccountNumber, long accountNumber) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.amount = amount;
		this.sendingAccountNumber = sendingAccountNumber;
		this.receivingAccountNumber = receivingAccountNumber;
		this.accountNumber = accountNumber;
	}


	public Transactions(long amount, long sendingAccountNumber, long receivingAccountNumber) {
		super();
		this.amount = amount;
		this.sendingAccountNumber = sendingAccountNumber;
		this.receivingAccountNumber = receivingAccountNumber;
	}


	public Transactions(long amount, long accountNumber) {
		super();
		this.amount = amount;
		this.accountNumber = accountNumber;
	}


	public Transactions(Date date, long amount, long accountNumber) {
		super();
		this.date = date;
		this.amount = amount;
		this.accountNumber = accountNumber;
	}


	public long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public long getAmount() {
		return amount;
	}


	public void setAmount(long amount) {
		this.amount = amount;
	}


	public long getSendingAccountNumber() {
		return sendingAccountNumber;
	}


	public void setSendingAccountNumber(long sendingAccountNumber) {
		this.sendingAccountNumber = sendingAccountNumber;
	}


	public long getReceivingAccountNumber() {
		return receivingAccountNumber;
	}


	public void setReceivingAccountNumber(long receivingAccountNumber) {
		this.receivingAccountNumber = receivingAccountNumber;
	}


	public long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", date=" + date + ", amount=" + amount
				+ ", sendingAccountNumber=" + sendingAccountNumber + ", receivingAccountNumber="
				+ receivingAccountNumber + ", accountNumber=" + accountNumber + "]";
	}




	
}
