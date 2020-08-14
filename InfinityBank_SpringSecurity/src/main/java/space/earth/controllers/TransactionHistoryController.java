package space.earth.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import space.earth.entities.PrimaryTransaction;
import space.earth.entities.SavingsTransaction;
import space.earth.formModels.ProfileUserId;
import space.earth.service.PrimaryAccountService;
import space.earth.service.PrimaryTransactionService;
import space.earth.service.SavingsAccountService;
import space.earth.service.SavingsTransactionService;
import space.earth.service.UserService;

@Controller
@RequestMapping
public class TransactionHistoryController {
	@Autowired
	private PrimaryTransactionService primaryTransactionService; 
	@Autowired
	private SavingsTransactionService savingsTransactionService; 
	
	@Autowired 
	private UserService userService; 
	
	@Autowired
	private PrimaryAccountService primaryAccountService;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	

	@PostMapping("/primaryTransaction")
	private ModelAndView primaryTransaction(@ModelAttribute ProfileUserId profileUserId) {
		ModelAndView history = new ModelAndView("primaryTransactionHistory");
		
		int userId = profileUserId.getUserId();
		
		int primaryAccountId = userService.findById(userId).get().getPrimaryAccount().getId(); 
		
		List<Integer> transactionIds = new ArrayList<>(); 
		transactionIds = primaryAccountService.getTransactionIdsByAccountId(primaryAccountId);

		List<PrimaryTransaction> primaryTransactions = new ArrayList<>();
		primaryTransactions = primaryTransactionService.getByTransactionIds(transactionIds);
		
		history.addObject("PrimaryTransactions", primaryTransactions);
		history.addObject("ProfileUserId", profileUserId);

		return history;
	}

	@PostMapping("/savingsTransaction")
	private ModelAndView savingsTransaction(@ModelAttribute ProfileUserId profileUserId) {
		ModelAndView history = new ModelAndView("savingsTransactionHistory");
int userId = profileUserId.getUserId();
		
		int savingsAccountId = userService.findById(userId).get().getSavingsAccount().getId(); 
		
		List<Integer> transactionIds = new ArrayList<>(); 
		transactionIds = savingsAccountService.getTransactionIdsByAccountId(savingsAccountId);

		List<SavingsTransaction> savingsTransactions = new ArrayList<>();
		savingsTransactions = savingsTransactionService.getByTransactionIds(transactionIds);
		history.addObject("SavingsTransactions", savingsTransactions);
		history.addObject("ProfileUserId", profileUserId);
		return history;

	}

}
