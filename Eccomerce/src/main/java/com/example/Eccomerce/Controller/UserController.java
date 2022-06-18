package com.example.Eccomerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Eccomerce.Security.JWTUtil;
import com.example.Eccomerce.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserService userS;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@GetMapping("/ola")
	public String digaOla(@RequestHeader(required = true, name = "Authorization") String token) throws Exception {
		return "olá";
}
}
