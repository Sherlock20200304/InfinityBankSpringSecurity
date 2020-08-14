package space.earth.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.utility.RandomString;
import space.earth.dao.PrimaryAccountDAO;
import space.earth.entities.PrimaryAccount;
import space.earth.entities.PrimaryTransaction;
import space.earth.formModels.ATM;
import space.earth.formModels.Transfer;

@Service
public class PrimaryAccountService {
	@Autowired 
	private PrimaryAccountDAO dao; 
	
	public void save(PrimaryAccount account) {
		 dao.save(account);
	}
	
	

	public Optional<PrimaryAccount> findById(int id) {
		return dao.findById(id);
		
	}



	public PrimaryAccount create() {
		String accountNumber = RandomString.make(5);
		PrimaryAccount primaryAccount = new PrimaryAccount(accountNumber,new BigDecimal("0"));
		dao.save(primaryAccount);
		return primaryAccount;
	}



	public void updateBalanceWithTransfer(Transfer transfer, int primaryAccountId) {
		BigDecimal amount = transfer.getAmount(); 
		BigDecimal originalBalance = dao.findById(primaryAccountId).get().getBalance();
		PrimaryAccount primaryAccount = new PrimaryAccount();
		primaryAccount = dao.findById(primaryAccountId).get();
		if (transfer.getTransferFrom().equals("primaryAccount") ) {
			
			
					primaryAccount.setBalance(originalBalance.subtract(amount));
					dao.save(primaryAccount);
		}
		else if (transfer.getTransferTo().equals("primaryAccount")) {
			
			
		
			primaryAccount.setBalance(originalBalance.add(amount));
			dao.save(primaryAccount);
			
		}
		
	}



	public void updateBalanceWithAtm(ATM atm, int primaryAccountId) {
		BigDecimal amount = atm.getAmount(); 
		BigDecimal originalBalance = dao.findById(primaryAccountId).get().getBalance();
		PrimaryAccount primaryAccount = new PrimaryAccount();
		primaryAccount = dao.findById(primaryAccountId).get();
		if (atm.getType().equals("deposit")) {
			primaryAccount = dao.findById(primaryAccountId).get();
			primaryAccount.setBalance(originalBalance.add(amount));
			dao.save(primaryAccount); 
		}
		else if(atm.getType().equals("withdraw")) {
			primaryAccount=dao.findById(primaryAccountId).get();
			primaryAccount.setBalance(originalBalance.subtract(amount));
			dao.save(primaryAccount); 
		}
		
	}
	
	public List<Integer> getTransactionIdsByAccountId(int accountId) {
		List<PrimaryTransaction> primaryTransactions = new ArrayList <> (); 
		primaryTransactions = dao.findById(accountId).get().getPrimaryTransactions();
		
		List<Integer> primaryTransactionIds = new ArrayList<Integer> (); 
		
		for (int i = 0; i < primaryTransactions.size(); i++) {
			int transactionId = primaryTransactions.get(i).getId(); 
			primaryTransactionIds.add(transactionId); 
		}
		
		return primaryTransactionIds; 
		
	}
	

}
