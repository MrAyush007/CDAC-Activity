package com.app.validate;

import java.util.Map;
import com.app.Exeception.Authenticat1ionException;
import com.app.entity.User;

public class UserValidate {
	public static User uservalidate(String email,String pass,Map<String,User> map) throws Authenticat1ionException
	{
		User u1=map.get(email);
		if(u1!=null) 
		{
			if(u1.getPass().equals(pass)) 
			{
				return u1;
			}
		}
		throw new Authenticat1ionException("Ivalid E-mail!!!!");
	}
}
