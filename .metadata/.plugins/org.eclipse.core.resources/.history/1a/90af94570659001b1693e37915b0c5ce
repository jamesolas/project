package com.app.model;

public class AccountRequests {
	private long balance;
	private long requestId;
	
	
	
	public AccountRequests() {
		super();
	}

	public AccountRequests(long balance, long requestId) {
		super();
		this.balance = balance;
		this.requestId = requestId;
	}

	public AccountRequests(long requestId) {
		super();
		this.requestId = requestId;	
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (balance ^ (balance >>> 32));
		result = prime * result + (int) (requestId ^ (requestId >>> 32));
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
		AccountRequests other = (AccountRequests) obj;
		if (balance != other.balance)
			return false;
		if (requestId != other.requestId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountRequests [balance=" + balance + ", requestId=" + requestId + "]";
	}
	
	
	

}
