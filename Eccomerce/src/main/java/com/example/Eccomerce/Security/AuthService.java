package com.example.Eccomerce.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.Model.User;
import com.example.Eccomerce.Service.UserService;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	UserService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = service.findByUsername(username);
		if(user==null) {
			return null;
		}
		return new UserSS(user.getId(), user.getEmail(), user.getSenha());
	}
}
