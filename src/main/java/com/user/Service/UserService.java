package com.user.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user.Model.User;

@Service
public class UserService {

	private static List<User> users = new ArrayList<User>();
	private static int userCount = 3;
	
	static {
	users.add(new User(1, "Adam", new Date()));
	users.add(new User(2, "Eve", new Date()));
	users.add(new User(3, "Nupur", new Date()));
	}
	
	//finding all users list
	public List<User> findall(){
		return users;
	}
	
	// saving new user to the array list
	public User save(User user) {
		if (user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	//finding an user by id
	public User findOne(int id) {
		for (User user:users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	//delete user by id
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId()==id) {
				iterator.remove();
				return user;
			}
			
		}
		return null;
	}
}
