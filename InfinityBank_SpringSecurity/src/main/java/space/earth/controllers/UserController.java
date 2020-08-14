package space.earth.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import space.earth.entities.PrimaryAccount;
import space.earth.entities.SavingsAccount;
import space.earth.entities.User;

import space.earth.service.PrimaryAccountService;
import space.earth.service.SavingsAccountService;
import space.earth.service.UserService;

@Controller

@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PrimaryAccountService primaryAccountService;
	
	@Autowired
	private SavingsAccountService savingsAccountService; 

	@RequestMapping("signup")
	public ModelAndView User(@ModelAttribute User user) {

		ModelAndView modelAndView = new ModelAndView("signup");

		return modelAndView;
	}

	@RequestMapping(value = "signup/adduser", method = RequestMethod.POST)

	public ModelAndView adduser(@ModelAttribute("user") User user) {

		ModelAndView modelAndView = new ModelAndView("login");
		
		PrimaryAccount primaryAccount = primaryAccountService.create(); 
		SavingsAccount savingsAccount = savingsAccountService.create();

		userService.create(user, primaryAccount, savingsAccount); // need to fix this statement
		

		return modelAndView;

	}

	@GetMapping("login")

	public String loginPage() {

		return "login";
	}
	
	@GetMapping("/")

	public String home() {

		return "redirect:/index";
	}
	
	@GetMapping("/index")

	public String index() {

		return "index";
	}

//	@PostMapping("login")
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//
//		if (correct(username, password)) {
//			request.getSession().invalidate();
//			HttpSession newSession = request.getSession(true);
//			newSession.setMaxInactiveInterval(300);
//
//			Cookie cUserId = new Cookie("Username", username);
//			response.addCookie(cUserId);
//
//			Cookie cPassword = new Cookie("Password", password);
//			response.addCookie(cPassword);
//
//			ModelAndView profile = new ModelAndView("profile");
//
//			User user = new User();
//			user = userService.findByUsername(username);
//			profile.addObject("User", user);
//			
//			ProfileUserId profileUserId = new ProfileUserId();
//			
//			
//	
//			profile.addObject("ProfileUserId", profileUserId);
//			
//
//			return profile;
//
//		} else {
//			ModelAndView signup = new ModelAndView("signup");
//
//			User user = new User();
//			signup.addObject("user", user);
//			return signup;
//
//		}
//
//	}

//	private boolean correct(String username, String password) {
//
//		if (userService.existByUsername(username)) {
//
//			if (userService.findByUsername(username).getPassword().equals(password)) {
//				return true;
//			} else {
//				return false;
//			}
//
//		} else {
//			return false;
//		}
//
//	}

//	@PostMapping("logout")
//	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		String status = request.getParameter("status");
//
//		switch (status) {
//		case "destroy":
//
//			request.getSession().invalidate();
//			Cookie[] cookies = request.getCookies();
//
//			for (Cookie item : cookies) {
//				if (item.getName().equals("Username")) {
//					item.setValue(null);
//					item.setMaxAge(0);
//					response.addCookie(item);
//				}
//				if (item.getName().equals("Password")) {
//					item.setValue(null);
//					item.setMaxAge(0);
//					response.addCookie(item);
//				}
//				if (item.getName().equals("JSESSIONID")) {
//					item.setValue(null);
//					item.setMaxAge(0);
//					response.addCookie(item);
//				}
//			}
//
//			ModelAndView index = new ModelAndView("index");
//			return index;
//
//		default:
//			ModelAndView profile = new ModelAndView("profile");
//			return profile;
//		}
//
//	}

}
