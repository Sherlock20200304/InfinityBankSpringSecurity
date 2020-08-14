package space.earth.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SavingsAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	private String accountNumber;
	private BigDecimal balance;
	
	@OneToMany
	private List<SavingsTransaction> savingsTransactions; 
	
	
	
	
	public SavingsAccount(String accountNumber, BigDecimal balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}


	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public List<SavingsTransaction> getSavingsTransactions() {
		return savingsTransactions;
	}


	public void setSavingsTransactions(List<SavingsTransaction> savingsTransactions) {
		this.savingsTransactions = savingsTransactions;
	} 
	
	
	

}
