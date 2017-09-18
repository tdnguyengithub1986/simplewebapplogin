package com.tdn.Controllers;

import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.tdn.Models.User;
import com.tdn.Services.GetData;
import com.tdn.Services.LogInService;

@Controller
public class LogInController {

	@Autowired
	LogInService checkLogingCredential;

	@Autowired
	GetData getData;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginAsHomePage() {
		return "logIn";
	}

	@RequestMapping(value = "/loginStatus", method = RequestMethod.POST)
	public String checkCredential(@RequestParam("userName") String name,

			@RequestParam String password, ModelMap modelMap) {

		if (checkLogingCredential.springValidate(name, password)) {

			String role = checkLogingCredential.get_loginedUserRole();
			String table = getData.CreateJspTable(role);
			modelMap.put("table", table);
			return "userList";
		} else {
			modelMap.put("errorMessage", " Your credentials was entered incorrectly, please try again!");
			return "logIn";
		}

	}

	/*
	 * @RequestMapping(value = "/loginStatus", method = RequestMethod.POST)
	 * public String checkCredential(@ModelAttribute("loggingInCredentials")
	 * User loggingInCredentials, ModelMap modelMap) {
	 * System.out.println(loggingInCredentials.get_userName()+":"+
	 * loggingInCredentials.get_password()); if
	 * (checkLogingCredential.springValidate(loggingInCredentials.get_userName()
	 * , loggingInCredentials.get_password())) {
	 * 
	 * String role = checkLogingCredential.get_loginedUserRole(); String table =
	 * getData.CreateJspTable(role); modelMap.put("table", table); return
	 * "userList"; } else {
	 * 
	 * modelMap.put("errorMessage",
	 * " Your credentials was entered incorrectly, please try again!"); return
	 * "logIn"; } }
	 */
}
