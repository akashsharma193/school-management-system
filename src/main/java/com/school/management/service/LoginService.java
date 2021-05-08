package com.school.management.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.management.Repo.UserRepo;
import com.school.management.entity.UserInfo;

@Service
public class LoginService implements UserDetailsService{

	@Autowired
	UserRepo usrRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = usrRepo.getByEmail(username);
		if(user!=null) {
			return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User Not Found !!!");
		}
		
	}

}
