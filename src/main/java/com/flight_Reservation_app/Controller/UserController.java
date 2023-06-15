package com.flight_Reservation_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_Reservation_app.Entity.User;
import com.flight_Reservation_app.Repository.UserRepositry;

@Controller
public class UserController {
	@Autowired
	private UserRepositry userRepo;
	
	//for showing the login page in front page 
	
	@RequestMapping("/ShowLoginPage")
	public String ShowLoginPage() {
		return  "login/login";
	}
	
	
	@RequestMapping("/showReg")
	public String showReg() {
		
		return "login/showReg";
	}
	
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		
		return "login/login";
	}

	@RequestMapping("/verifyLogin")
	public String VerifyLogin(@RequestParam("emailId")String emailId,@RequestParam("password")String password,ModelMap model) {
		User user = userRepo.findByEmail( emailId);
//		System.out.println(user.getEmail());
//		System.out.println(user.getPassword());
		if(user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
			return "find_Flights";
		}else {
			model.addAttribute("error", "invalid username/password");
			return "login/login";
		}
		
		
		
	}
}
