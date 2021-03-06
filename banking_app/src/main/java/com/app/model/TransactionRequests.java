package com.app.model;

import java.util.Date;

public class TransactionRequests {
	private long amount;
	private Date date;
	private long sendingAccount;
	private long receivingAccount;
	private long requestId;
	
	public TransactionRequests() {
		// TODO Auto-generated constructor stub
	}
	

	public TransactionRequests(long receivingAccount) {
		super();
		this.receivingAccount = receivingAccount;
	}


	public TransactionRequests(long amount, Date date, long sendingAccount, long receivingAccount, long requestId) {
		super();
		this.amount = amount;
		this.date = date;
		this.sendingAccount = sendingAccount;
		this.receivingAccount = receivingAccount;
		this.requestId = requestId;
	}

	
	
	public TransactionRequests(long amount, long sendingAccount, long receivingAccount) {
		super();
		this.amount = amount;
		this.sendingAccount = sendingAccount;
		this.receivingAccount = receivingAccount;
	}

	public TransactionRequests(long amount, Date date, long sendingAccount, long receivingAccount) {
		super();
		this.amount = amount;
		this.date = date;
		this.sendingAccount = sendingAccount;
		this.receivingAccount = receivingAccount;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getSendingAccount() {
		return sendingAccount;
	}

	public void setSendingAccount(long sendingAccount) {
		this.sendingAccount = sendingAccount;
	}

	public long getReceivingAccount() {
		return receivingAccount;
	}

	public void setReceivingAccount(long receivingAccount) {
		this.receivingAccount = receivingAccount;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}


	@Override
	public String toString() {
		return "TransactionRequests [amount=" + amount + ", date=" + date + ", sendingAccount=" + sendingAccount
				+ ", receivingAccount=" + receivingAccount + ", requestId=" + requestId + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (receivingAccount ^ (receivingAccount >>> 32));
		result = prime * result + (int) (requestId ^ (requestId >>> 32));
		result = prime * result + (int) (sendingAccount ^ (sendingAccount >>> 32));
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
		TransactionRequests other = (TransactionRequests) obj;
		if (amount != other.amount)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (receivingAccount != other.receivingAccount)
			return false;
		if (requestId != other.requestId)
			return false;
		if (sendingAccount != other.sendingAccount)
			return false;
		return true;
	}

	
	
}
