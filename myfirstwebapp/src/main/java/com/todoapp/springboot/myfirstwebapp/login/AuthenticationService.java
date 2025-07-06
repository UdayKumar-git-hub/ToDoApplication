package com.todoapp.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String Username,String Password)
	{
		boolean isValidUserName = Username.equalsIgnoreCase("UdayKumar");
		boolean isValidPassword = Password.equalsIgnoreCase("pass");
		return isValidUserName&&isValidPassword;
		
	}
	
}
