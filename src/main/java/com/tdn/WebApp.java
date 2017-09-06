package com.tdn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebApp {

	public static void main(String[] args) {
		
		ApplicationContext userBeans = new ClassPathXmlApplicationContext("user_beans.xml");
		
		User admin = (User) userBeans.getBean("0");
		
		((ClassPathXmlApplicationContext) userBeans).close();
		
		System.out.println("Administer details: " + admin);
	}

}
