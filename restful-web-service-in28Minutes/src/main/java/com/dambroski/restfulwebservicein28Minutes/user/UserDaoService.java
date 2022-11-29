package com.dambroski.restfulwebservicein28Minutes.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;



@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static long userIds = 2;
	
	static {
		User leticia = User.builder().id((long) 1).name("Leticia").birthDate(LocalDate.of(2002, 5, 23)).build();
		User thiago = User.builder().id((long) 2).name("Thiago").birthDate(LocalDate.of(2002, 2, 16)).build();
		users.add(leticia);
		users.add(thiago);
	}
	
	public List<User> getAll(){
		return users;
	}
	
	
	public User getUserById(long id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}
	
	public User postUser(User user) {
		userIds++;
		user.setId(userIds);
		users.add(user);
		
		return user;
	}
	


}
