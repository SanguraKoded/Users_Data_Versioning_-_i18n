package com.sangura.users_versioning1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangura.users_versioning1.entities.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{

}
