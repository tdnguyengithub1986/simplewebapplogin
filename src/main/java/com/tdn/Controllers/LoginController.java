package com.tdn.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tdn.Services.GetData;
import com.tdn.Services.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	LoginService checkLogingCredential;
	
	@Autowired
	GetData getData;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginAsHomePage(){
		return "userList";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(){
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkCredential(@RequestParam String userName, 
								  @RequestParam String password,
								  ModelMap model){
		if(checkLogingCredential.springValidate(userName, password)){
			
			String table = getData.CreateJspTable();
			model.put("table", table);
			return "userList";
		}else{
			model.put("errorMessage","Loging credential was entered incorrectly, please try again!");
			return "login";
		}
	}
}
