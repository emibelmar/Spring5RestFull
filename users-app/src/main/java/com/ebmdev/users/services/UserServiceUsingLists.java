package com.ebmdev.users.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ebmdev.users.models.User;
import com.github.javafaker.Faker;

@Service
public class UserServiceUsingLists {

	@Autowired
	private Faker faker;

	private List<User> users = new ArrayList<>();

	@PostConstruct
	public void init() {
		for (int i = 0; i < 100; i++) {
			users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
		}
	}

	public List<User> getUsers(String startWith) {
		if (Objects.nonNull(startWith)) {
			return users.stream().filter(u -> u.getUsername().startsWith(startWith)).collect(Collectors.toList());
		} else {
			return users;
		}
	}

	public User getUserByUsername(String username) {
		return users.stream().filter(u -> u.getUsername().equals(username)).findAny().orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found.", username)));
	}

	public User createUser(User user) {
		if (users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					String.format("User %s already exists", user.getUsername()));
		}

		users.add(user);
		return user;
	}

	public User updateUser(User user) {
		User userToBeUpdated = getUserByUsername(user.getUsername());

		userToBeUpdated.setNickName(user.getNickName());
		userToBeUpdated.setUsername(user.getUsername());
		userToBeUpdated.setPassword(user.getPassword());

		return userToBeUpdated;
	}

	public void deleteUser(String username) {
		User userToBeDeleted = getUserByUsername(username);
		users.remove(userToBeDeleted);
	}
}