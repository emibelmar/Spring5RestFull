package com.ebmdev.users.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebmdev.users.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByUsername(String username);

	public Optional<User> findByUsernameAndPassword(String username, String password);

	@Query("SELECT u.username FROM User u")
	public Page<String> findUsernames(Pageable pagable);

}
