package space.earth.formModels;

import java.math.BigDecimal;

public class ATM {

	
	private int userId; 
	private String type; // deposit or withdraw
	private String account; 
	private BigDecimal amount;
	
	
	public ATM() {
		// TODO Auto-generated constructor stub
	}


	public ATM(int userId, String type, String account, BigDecimal amount) {
		super();
		this.userId = userId;
		this.type = type;
		this.account = account;
		this.amount = amount;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
	

}
