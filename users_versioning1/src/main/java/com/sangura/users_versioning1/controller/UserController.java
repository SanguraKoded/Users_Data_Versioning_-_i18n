package com.sangura.users_versioning1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangura.users_versioning1.DTO.UsersV1DTO;
import com.sangura.users_versioning1.entities.Users;
import com.sangura.users_versioning1.services.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UsersService usersService;
	
	private MessageSource messageSource;
	
	public UserController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
	@GetMapping(params="version=1")
	public ResponseEntity<List<UsersV1DTO>> getAllV1Users(){
		Locale locale = LocaleContextHolder.getLocale();
		messageSource.getMessage("user.welcome.message", null, locale);
		messageSource.getMessage("userv1.message", null, locale);
		
		return ResponseEntity.ok(usersService.getAllUsersV1());
	}
	
	@GetMapping(params="version=2" )
	public ResponseEntity<Map<String, Object>> getAllV2Users(){
		Locale locale = LocaleContextHolder.getLocale();
		String welcomeMessage = messageSource.getMessage("user.welcome.message", null, locale);
		String versionMessage = messageSource.getMessage("userv2.message", null, locale);
		Map<String, Object> response = new HashMap<>();
		response.put("Welcome Message ",welcomeMessage);
		response.put("Version Message ", versionMessage);
		response.put("Users", usersService.getAllUsersV2());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping()
	public ResponseEntity<List<Users>> getAllUser(){
		return ResponseEntity.ok(usersService.getAllUsers());
	}
	
	@GetMapping("/welcome")
	public ResponseEntity<String> getMessage(){
		Locale locale = LocaleContextHolder.getLocale();
		
		return ResponseEntity.ok(messageSource.getMessage("user.welcome.message", null, null, locale));
	}

}
