package com.dambroski.restfulwebservicein28Minutes.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		User leticia = User.builder().id((long) 1).name("Leticia").birthDate(LocalDate.of(2002, 5, 23)).build();
		User thiago = User.builder().id((long) 2).name("Thiago").birthDate(LocalDate.of(2002, 2, 16)).build();
		users.add(leticia);
		users.add(thiago);
	}
	
	public List<User> getAll(){
		return users;
	}

}
