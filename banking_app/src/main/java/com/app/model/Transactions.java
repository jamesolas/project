package com.app.model;

public class Transactions {
	private long transactionId;
	private long date;
	private long amount;
	private long sendingAccountNumber;
	private long receivingAccountNumber;
	private long accountNumber;
	
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}


	public Transactions(long transactionId, long date, long amount, long sendingAccountNumber,
			long receivingAccountNumber, long account) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.amount = amount;
		this.sendingAccountNumber = sendingAccountNumber;
		this.receivingAccountNumber = receivingAccountNumber;
		this.accountNumber = accountNumber;
	}


	public long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}


	public long getDate() {
		return date;
	}


	public void setDate(long date) {
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


	public long getAccounNumbert() {
		return accountNumber;
	}


	public void setAccount(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result + (int) (date ^ (date >>> 32));
		result = prime * result + (int) (receivingAccountNumber ^ (receivingAccountNumber >>> 32));
		result = prime * result + (int) (sendingAccountNumber ^ (sendingAccountNumber >>> 32));
		result = prime * result + (int) (transactionId ^ (transactionId >>> 32));
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
		Transactions other = (Transactions) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (amount != other.amount)
			return false;
		if (date != other.date)
			return false;
		if (receivingAccountNumber != other.receivingAccountNumber)
			return false;
		if (sendingAccountNumber != other.sendingAccountNumber)
			return false;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", date=" + date + ", amount=" + amount
				+ ", sendingAccountNumber=" + sendingAccountNumber + ", receivingAccountNumber="
				+ receivingAccountNumber + ", account=" + accountNumber + "]";
	}

	
}
