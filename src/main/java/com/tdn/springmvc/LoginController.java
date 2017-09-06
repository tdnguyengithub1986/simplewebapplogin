package com.tdn.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tdn.springmvc.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	LoginService checkLogingCredential;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(){
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkCredential(@RequestParam String userName, 
								  @RequestParam String password,
								  ModelMap model){
		if(checkLogingCredential.validate(userName, password)){
		
		return "userList";
		}else{
			model.put("errorMessage","Loging credential was entered incorrectly, please try again!");
			return "login";
		}
	}
}
