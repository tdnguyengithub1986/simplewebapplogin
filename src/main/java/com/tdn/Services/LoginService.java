package com.tdn.Services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validate(String userName, String password){
		return userName.equals("administrator")&&password.equals("default");
	}
}
