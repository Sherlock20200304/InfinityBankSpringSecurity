package space.earth.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.utility.RandomString;
import space.earth.dao.PrimaryAccountDAO;
import space.earth.dao.PrimaryTransactionDAO;
import space.earth.entities.PrimaryAccount;
import space.earth.entities.PrimaryTransaction;
import space.earth.formModels.ATM;
import space.earth.formModels.Transfer;

@Service
public class PrimaryTransactionService {

	@Autowired
	private PrimaryTransactionDAO primaryTransactionDao;
	
	@Autowired
	private PrimaryAccountDAO primaryAccountDao;

	public PrimaryTransactionService() {
		// TODO Auto-generated constructor stub
	}

	public void createWithTransfer(Transfer transfer, int primaryAccountId) {

		Date date = new Date();
		String transactionNumber = RandomString.make(7);
		PrimaryTransaction primaryTransaction = new PrimaryTransaction();
		
		PrimaryAccount primaryAccount = new PrimaryAccount(); 
		primaryAccount = primaryAccountDao.findById(primaryAccountId).get();
		
		primaryTransaction.setTransactionAmount(transfer.getAmount());
		primaryTransaction.setTransactionDate(date);
		primaryTransaction.setTransactionDescription(
				"Transfer from " + transfer.getTransferFrom() + " to " + transfer.getTransferTo());
		primaryTransaction.setTransactionNumber(transactionNumber);
		primaryTransaction.setTransactionType("transfer");
		primaryTransaction.setPrimaryAccount(primaryAccount);

		primaryTransactionDao.save(primaryTransaction);
		
		List<PrimaryTransaction> primaryTransactions = new ArrayList <> (); 
		primaryTransactions = primaryAccount.getPrimaryTransactions();
		primaryTransactions.add(primaryTransaction); 
		
		primaryAccount.setPrimaryTransactions(primaryTransactions);

	}

	public void createWithATM(ATM atm, int primaryAccountId) {
		Date date = new Date();
		String transactionNumber = RandomString.make(7);
		PrimaryTransaction primaryTransaction = new PrimaryTransaction();
		
		PrimaryAccount primaryAccount = new PrimaryAccount(); 
		primaryAccount = primaryAccountDao.findById(primaryAccountId).get();
		
		primaryTransaction.setTransactionAmount(atm.getAmount());
		primaryTransaction.setTransactionDate(date);
		primaryTransaction.setTransactionNumber(transactionNumber);
		primaryTransaction.setPrimaryAccount(primaryAccount);
		
		
		
		if (atm.getType().equals("deposit")) {
			primaryTransaction.setTransactionDescription(
					"Deposit to " + atm.getAccount());
			primaryTransaction.setTransactionType("deposit");
			
		}
		else if (atm.getType().equals("withdraw")) {
			
			primaryTransaction.setTransactionDescription(
					"Withdraw from " + atm.getAccount());
			primaryTransaction.setTransactionType("withdraw");
		}
		

		primaryTransactionDao.save(primaryTransaction);
		
		List<PrimaryTransaction> primaryTransactions = new ArrayList <> (); 
		primaryTransactions = primaryAccount.getPrimaryTransactions();
		primaryTransactions.add(primaryTransaction); 
		
		primaryAccount.setPrimaryTransactions(primaryTransactions);
		
	}

	public List<PrimaryTransaction> getAll() {
		return (List<PrimaryTransaction>) primaryTransactionDao.findAll();
		
	}
	
	public List<PrimaryTransaction> getByTransactionIds(List<Integer> transactionIds) {
		
		List<PrimaryTransaction> primaryTransactions = new ArrayList<>(); 
		
		for (int i = 0; i < transactionIds.size(); i++) {
			int transactionId = transactionIds.get(i); 
			PrimaryTransaction primaryTransaction =primaryTransactionDao.findById(transactionId).get(); 
			primaryTransactions.add(primaryTransaction); 
		}
		return primaryTransactions; 
		
	}

}
