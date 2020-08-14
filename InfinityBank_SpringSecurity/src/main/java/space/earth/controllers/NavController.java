package space.earth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import space.earth.entities.User;
import space.earth.formModels.ProfileUserId;
import space.earth.service.UserService;

@Controller
@RequestMapping("nav")
public class NavController {
	
	@Autowired 
	private UserService userService; 
	
 @RequestMapping ("home")
	public ModelAndView home ( @ModelAttribute ProfileUserId profileUserId ) {
	 
	 
	 ModelAndView modelAndView = new ModelAndView("profile");
	 
	modelAndView.addObject("ProfileUserId", profileUserId);
	
	int userId=profileUserId.getUserId();
	User user = new User (); 
	user =userService.findById(userId).get();
	
	modelAndView.addObject("User", user);
	
	 
		return modelAndView;
	}
 
	
	

}
