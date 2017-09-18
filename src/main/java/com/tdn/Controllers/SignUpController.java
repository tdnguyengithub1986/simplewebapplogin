package com.tdn.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tdn.Models.User;
import com.tdn.Services.SignUpService;

@Controller
public class SignUpController {
	
	@Autowired
	SignUpService signupService;
	
	private String userNameSuggestion="userNameSuggestion";
	private String passwordSuggestion="passwordSuggestion";
	private String confirmPasswordSuggestion = "confirmPasswordSuggestion";
	private String errorMessage = "";
	
	
	@RequestMapping (value ="/signuppage", method = RequestMethod.GET)
	public String showSignupPage(ModelMap modelMap){
		
			modelMap.put(userNameSuggestion, "<td style=\"color:#6c3d7e; width:500px\">" +"Please choose your user name!"+"</td>");
			modelMap.put(passwordSuggestion, "<td style=\"color:#6c3d7e; width:500px\">" +"Please choose a pass word for your account!"+"</td>");
			modelMap.put(confirmPasswordSuggestion, "<td style=\"color:#6c3d7e; width:500px\">" +"Please re-enter the above password for confirmation!"+"</td>");
		
		
		return "signUpForm";
	}
	
	/*@RequestMapping (value ="/signup", method = RequestMethod.POST)
	public String submitSignupDetails(ModelMap modelMap,
									@RequestParam String userName,
									@RequestParam String password,
									@RequestParam String confirmedPassword){
		signupService.resetErrorMessage();
		if(!signupService.validateUserNameInput(userName)||!signupService.validatePasswordInput(password)||!signupService.validateConfirmPassword(password, confirmedPassword)){
			modelMap.put(userNameSuggestion, "<td style=\"color:red; width:500px\">" +signupService.get_userNameError()+"</td>");
			modelMap.put(passwordSuggestion, "<td style=\"color:red; width:500px\">" +signupService.get_passwordError()+"</td>");
			modelMap.put(confirmPasswordSuggestion, "<td style=\"color:red; width:500px\">" +signupService.get_confirmPasswordError()+"</td>");
			
			return "signUpForm";
		}
		
		//signupService.registerNewUser(userName, password);
		return "successedSignUp";
	}*/
	/*@RequestMapping (value ="/signup", method = RequestMethod.POST)
	public String submitSignupDetails(ModelMap modelMap,
									  @ModelAttribute("newUser") User newUser){
		signupService.resetErrorMessage();
		if(!signupService.validateUserNameInput(newUser.getUserName())||!signupService.validatePasswordInput(newUser.getPassword())||!signupService.validateConfirmPassword(newUser.getPassword(), newUser.getConfirmedPassword())){
			modelMap.put(userNameSuggestion, "<td style=\"color:red; width:500px\">" +signupService.get_userNameError()+"</td>");
			modelMap.put(passwordSuggestion, "<td style=\"color:red; width:500px\">" +signupService.get_passwordError()+"</td>");
			modelMap.put(confirmPasswordSuggestion, "<td style=\"color:red; width:500px\">" +signupService.get_confirmPasswordError()+"</td>");
			
			return "signUpForm";
		}
		
		//signupService.registerNewUser(newUser.getUserName(), newUser.getPassword());
		return "successedSignUp";
	}*/
	
	@RequestMapping (value ="/signup", method = RequestMethod.POST)
	public ModelAndView submitSignupDetails(@Valid @ModelAttribute("newUser") User newUser,
									  BindingResult bindingResult){
		System.out.println(newUser.getUserName()+":"+newUser.getPassword());
		
		if(bindingResult.hasErrors()){
			ModelAndView mav = new ModelAndView("signUpForm");
			
			return mav;
		}
		
		//signupService.registerNewUser(newUser.getUserName(), newUser.getPassword());
		ModelAndView mav = new ModelAndView("successedSignUp");
		return mav;
	}
	

}
