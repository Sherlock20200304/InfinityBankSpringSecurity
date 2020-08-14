package space.earth.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.utility.RandomString;
import space.earth.dao.SavingsAccountDAO;
import space.earth.dao.SavingsTransactionDAO;
import space.earth.entities.SavingsAccount;
import space.earth.entities.SavingsTransaction;
import space.earth.formModels.ATM;
import space.earth.formModels.Transfer;

@Service
public class SavingsTransactionService {

	@Autowired
	private SavingsTransactionDAO savingsTransactionDao;

	@Autowired
	private SavingsAccountDAO savingsAccountDao;

	public SavingsTransactionService() {
		// TODO Auto-generated constructor stub
	}

	public void createWithTransfer(Transfer transfer, int savingsAccountId) {

		Date date = new Date();
		String transactionNumber = RandomString.make(7);
		SavingsTransaction savingsTransaction = new SavingsTransaction();
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount = savingsAccountDao.findById(savingsAccountId).get();

		savingsTransaction.setTransactionAmount(transfer.getAmount());
		savingsTransaction.setTransactionDate(date);
		savingsTransaction.setTransactionDescription(
				"Transfer from " + transfer.getTransferFrom() + " to " + transfer.getTransferTo());
		savingsTransaction.setTransactionNumber(transactionNumber);
		savingsTransaction.setTransactionType("transfer");
		savingsTransaction.setSavingsAccount(savingsAccount);

		savingsTransactionDao.save(savingsTransaction);

		List<SavingsTransaction> savingsTransactions = new ArrayList<>();
		savingsTransactions = savingsAccount.getSavingsTransactions();
		savingsTransactions.add(savingsTransaction);

		savingsAccount.setSavingsTransactions(savingsTransactions);

	}

	public void createWithATM(ATM atm, int savingsAccountId) {
		Date date = new Date();
		String transactionNumber = RandomString.make(7);
		SavingsTransaction savingsTransaction = new SavingsTransaction();

		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount = savingsAccountDao.findById(savingsAccountId).get();
		savingsTransaction.setTransactionAmount(atm.getAmount());
		savingsTransaction.setTransactionDate(date);
		savingsTransaction.setTransactionNumber(transactionNumber);
		savingsTransaction.setSavingsAccount(savingsAccount);

		if (atm.getType().equals("deposit")) {
			savingsTransaction.setTransactionDescription("Deposit to " + atm.getAccount());
			savingsTransaction.setTransactionType("deposit");

		} else if (atm.getType().equals("withdraw")) {

			savingsTransaction.setTransactionDescription("Withdraw from " + atm.getAccount());
			savingsTransaction.setTransactionType("withdraw");
		}

		savingsTransactionDao.save(savingsTransaction);

		List<SavingsTransaction> savingsTransactions = new ArrayList<>();
		savingsTransactions = savingsAccount.getSavingsTransactions();
		savingsTransactions.add(savingsTransaction);

		savingsAccount.setSavingsTransactions(savingsTransactions);

	}

	public List<SavingsTransaction> getAll() {
		return (List<SavingsTransaction>) savingsTransactionDao.findAll();
	}

	public List<SavingsTransaction> getByTransactionIds(List<Integer> transactionIds) {
		List<SavingsTransaction> savingsTransactions = new ArrayList<>();
		
		for (int i = 0; i < transactionIds.size(); i++) {
			int transactionId = transactionIds.get(i);
			SavingsTransaction savingsTransaction = new SavingsTransaction();
			savingsTransaction = savingsTransactionDao.findById(transactionId).get();
			savingsTransactions.add(savingsTransaction);
		}
		return savingsTransactions;
	}

}
