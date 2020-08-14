package space.earth.formModels;

import java.math.BigDecimal;

public class Transfer {

	private int userId; 
	private String transferTo;
	private String transferFrom; 
	private BigDecimal amount; 
	
	
	public Transfer() {
		// TODO Auto-generated constructor stub
	}


	public Transfer(int userId, String transferTo, String transferFrom, BigDecimal amount) {
		super();
		this.userId = userId;
		this.transferTo = transferTo;
		this.transferFrom = transferFrom;
		this.amount = amount;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getTransferTo() {
		return transferTo;
	}


	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}


	public String getTransferFrom() {
		return transferFrom;
	}


	public void setTransferFrom(String transferFrom) {
		this.transferFrom = transferFrom;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	

	
	

}
