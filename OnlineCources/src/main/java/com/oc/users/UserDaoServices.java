package com.oc.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoServices {

	private static List<User> users = new ArrayList<User>();
	private static int userCount;

	static {
		users.add(new User(1, "Suhail", new Date()));
		users.add(new User(2, "Ramesh", new Date()));
		users.add(new User(3, "Suresh", new Date()));
		userCount = users.size();
	}

	public User getUser(Integer id) {
		for (User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public List<User> getUsers(){
		return users;
	}
	
	public User saveUser(User user){
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	
	public User deleteUser(Integer id) {
		for (User user : users) {
			if(user.getId()==id) {
				users.remove(user);
				return user;
			}
		}
		return null;
	}
}
