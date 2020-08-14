package space.earth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import space.earth.entities.User;
import space.earth.formModels.ATM;
import space.earth.formModels.ProfileUserId;
import space.earth.formModels.Transfer;
import space.earth.service.PrimaryAccountService;
import space.earth.service.PrimaryTransactionService;
import space.earth.service.SavingsAccountService;
import space.earth.service.SavingsTransactionService;
import space.earth.service.UserService;

@Controller
public class TransactionController {
	@Autowired
	private PrimaryTransactionService primaryTransactionService; 
	
	@Autowired
	private SavingsTransactionService savingsTransactionService; 
	
	@Autowired 
	private PrimaryAccountService primaryAccountService; 
	
	@Autowired 
	private SavingsAccountService savingsAccountService; 
	
	@Autowired 
	private UserService userService; 
	
	
@PostMapping("transferBetweenAccounts")
	public ModelAndView transferBetweenAccountsFormLoader (@ModelAttribute ProfileUserId profileUserId) {
	ModelAndView transfer = new ModelAndView ("transfer"); 
	
	Transfer info = new Transfer (); 
	transfer.addObject("Info", info); 
	transfer.addObject("ProfileUserId", profileUserId);
		return transfer; 
	}

@PostMapping("ATM")
public ModelAndView atmFormLoader (@ModelAttribute ProfileUserId profileFormInfo) {
	
	ModelAndView ATM = new ModelAndView ("ATM"); 
	ATM atm = new ATM(); 
	ATM.addObject("Atm", atm); 
	ATM.addObject("ProfileUserId", profileFormInfo); 
	return ATM; 
}

@PostMapping ("transferOperation")
public ModelAndView transferBetweenAccountsOperations (@ModelAttribute Transfer transfer) {
	
	ModelAndView profile = new ModelAndView ("profile"); 
	
	int userId = transfer.getUserId();
	int primaryAccountId = userService.getPrimaryAccountIdByUserId(userId);
	int savingsAccountId = userService.getSavingsAccountIdByUserId(userId); 
	
	if (transfer.getTransferFrom().equals("primaryAccount")) {
		primaryTransactionService.createWithTransfer(transfer, primaryAccountId); 
		primaryAccountService.updateBalanceWithTransfer(transfer,primaryAccountId);
		savingsAccountService.updateBalanceWithTransfer(transfer,savingsAccountId); 
		
	}
	else if (transfer.getTransferFrom().equals("savingsAccount")) {
		savingsTransactionService.createWithTransfer(transfer,savingsAccountId); 
		primaryAccountService.updateBalanceWithTransfer(transfer,primaryAccountId);
		savingsAccountService.updateBalanceWithTransfer(transfer,savingsAccountId); 
		
	}
	
	ProfileUserId profileUserId = new ProfileUserId();
	User user = userService.findById(userId).get();
	
	
	profile.addObject("ProfileUserId", profileUserId);
	profile.addObject("User", user);
	
	
	
	return profile; 
}

@PostMapping ("atmOperation")
public ModelAndView atmOperation(@ModelAttribute ATM atm) {
	ModelAndView profile = new ModelAndView ("profile"); 
	int userId = atm.getUserId();
	
	if (atm.getAccount().equals("primaryAccount")) {
		int primaryAccountId = userService.getPrimaryAccountIdByUserId(userId);
		primaryTransactionService.createWithATM(atm,primaryAccountId); 
		primaryAccountService.updateBalanceWithAtm(atm, primaryAccountId); 
	} 
	else if (atm.getAccount().equals("savingsAccount")) {
		int savingsAccountId = userService.getSavingsAccountIdByUserId(userId); 
		savingsTransactionService.createWithATM(atm,savingsAccountId); 
		savingsAccountService.updateBalanceWithAtm(atm, savingsAccountId);
		
	}
	
	
	ProfileUserId profileUserId = new ProfileUserId();
	User user = userService.findById(userId).get();
	
	
	
	profile.addObject("ProfileUserId", profileUserId);
	profile.addObject("User", user);
	
	return profile; 
}



}
