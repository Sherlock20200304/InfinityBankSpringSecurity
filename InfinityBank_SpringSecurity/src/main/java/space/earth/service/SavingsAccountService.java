package space.earth.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.utility.RandomString;
import space.earth.dao.SavingsAccountDAO;
import space.earth.entities.SavingsAccount;
import space.earth.entities.SavingsTransaction;
import space.earth.formModels.ATM;
import space.earth.formModels.Transfer;

@Service 
public class SavingsAccountService {
	
	@Autowired
	private SavingsAccountDAO dao;

	public SavingsAccount create() {
		String accountNumber = RandomString.make(5);
		SavingsAccount savingsAccount = new SavingsAccount(accountNumber,new BigDecimal("0"));
		dao.save(savingsAccount);
		return savingsAccount;}

	
		
	

	public void updateBalanceWithTransfer(Transfer transfer, int savingsAccountId) {
		BigDecimal amount = transfer.getAmount(); 
		
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount = dao.findById(savingsAccountId).get();
		
		BigDecimal originalBalance = savingsAccount.getBalance();
		if (transfer.getTransferFrom().equals("savingsAccount") ) {
			
		savingsAccount.setBalance(originalBalance.subtract(amount));
		dao.save(savingsAccount);
		}
		else if (transfer.getTransferTo().equals("savingsAccount")) {
			savingsAccount.setBalance(originalBalance.add(amount));
			dao.save(savingsAccount); 
			
		}
		
	}
	
	public void updateBalanceWithAtm(ATM atm, int savingsAccountId) {
		BigDecimal amount = atm.getAmount(); 
		
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount = dao.findById(savingsAccountId).get();
		
		BigDecimal originalBalance = savingsAccount.getBalance();
		
		if (atm.getType().equals("deposit")) {
			savingsAccount.setBalance(originalBalance.add(amount));
			dao.save(savingsAccount);
		}
		else if(atm.getType().equals("withdraw")) {
			savingsAccount.setBalance(originalBalance.subtract(amount));
			dao.save(savingsAccount);
		}
		
	}





	public List<Integer> getTransactionIdsByAccountId(int savingsAccountId) {
		List<SavingsTransaction> savingsTransactions = new ArrayList <> (); 
		savingsTransactions = dao.findById(savingsAccountId).get().getSavingsTransactions();
		
		List<Integer> savingsTransactionIds = new ArrayList<Integer> (); 
		
		for (int i = 0; i < savingsTransactions.size(); i++) {
			int transactionId = savingsTransactions.get(i).getId(); 
			savingsTransactionIds.add(transactionId); 
	}
		return savingsTransactionIds; }

}
