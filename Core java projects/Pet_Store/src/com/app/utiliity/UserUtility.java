package com.app.utiliity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.app.validate.UserValidate.*;

import com.app.Exeception.Authenticat1ionException;
import com.app.entity.Type;
import com.app.entity.User;

public class UserUtility {
	
	public static User loginUser(String email,String pass,Map<String,User> map) throws Authenticat1ionException{
		
		User u1 = uservalidate(email,pass,map);
			if(u1.getType() == Type.ADMIN) {
				u1.setAdmin(true);
			}
			return u1;
		}
	
	public static Map<String, User> populatedData(){
		Map<String, User> map = new HashMap<>();
		List<User> list = new ArrayList<>(
				Arrays.asList(new User("a@gmail.com","123",Type.ADMIN),
						new User("q@gmail.com","123",Type.USER),
						new User("e@gmail.com","123",Type.USER),
						new User("w@gmail.com","123",Type.USER))
				);
		
		list.forEach(s-> map.put(s.getEmail(),s));
		return map;
	}
	public static void displayUser(Map<String, User> map) 
	{
		map.values().stream().filter(s->s.getType()==Type.USER).forEach(s->System.out.println(s));
	}
	
		
	}

