package com.sangura.users_versioning1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangura.users_versioning1.DTO.UsersV1DTO;
import com.sangura.users_versioning1.DTO.UsersV2DTO;
import com.sangura.users_versioning1.entities.Users;
import com.sangura.users_versioning1.repo.UsersRepo;

@Service
public class UsersService {
	
	@Autowired
	UsersRepo userRepo;
	
	public List<UsersV1DTO> getAllUsersV1(){
		List<Users> users = userRepo.findAll();
		return users.stream().map(e -> new UsersV1DTO(e.getId(), e.getName(), e.getAge())).collect(Collectors.toList());
	}

	public List<UsersV2DTO> getAllUsersV2(){
		List<Users> users = userRepo.findAll();
		return users.stream().map(e -> new UsersV2DTO(e.getId(), e.getName(), e.getEmail(), e.getPhoneNumber())).collect(Collectors.toList());
	}
	
	public List<Users> getAllUsers(){
		return userRepo.findAll();
	}
}
