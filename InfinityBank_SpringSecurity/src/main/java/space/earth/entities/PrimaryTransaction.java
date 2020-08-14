package space.earth.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PrimaryTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	private String transactionType; 
	private String transactionNumber; 
	private Date transactionDate; 
	private String transactionDescription; 
	private BigDecimal transactionAmount;
	
	@ManyToOne
	private PrimaryAccount primaryAccount; 
	
	public PrimaryTransaction(String transactionType, String transactionNumber, Date transactionDate,
			String transactionDescription, BigDecimal transactionAmount) {
		super();
		this.transactionType = transactionType;
		this.transactionNumber = transactionNumber;
		this.transactionDate = transactionDate;
		this.transactionDescription = transactionDescription;
		this.transactionAmount = transactionAmount;
	}
	
	
	public PrimaryTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	


	public PrimaryAccount getPrimaryAccount() {
		return primaryAccount;
	}


	public void setPrimaryAccount(PrimaryAccount primaryAccount) {
		this.primaryAccount = primaryAccount;
	}


	@Override
	public String toString() {
		return "PrimaryTransaction [id=" + id + ", transactionType=" + transactionType + ", transactionNumber="
				+ transactionNumber + ", transactionDate=" + transactionDate + ", transactionDescription="
				+ transactionDescription + ", transactionAmount=" + transactionAmount + ", primaryAccount="
				+ primaryAccount + "]";
	}


	
	

}
