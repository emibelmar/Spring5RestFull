package com.ebmdev.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebmdev.users.entities.User;
import com.ebmdev.users.repositories.UserInRoleRepository;

@Service
public class UserInRoleService {

	@Autowired
	private UserInRoleRepository userInRoleRepository;

	public List<User> getUsersByRole(String roleName) {
		return userInRoleRepository.findUsersByRoleName(roleName);
	}
}
