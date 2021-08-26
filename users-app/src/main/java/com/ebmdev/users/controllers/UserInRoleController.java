package com.ebmdev.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebmdev.users.entities.User;
import com.ebmdev.users.services.UserInRoleService;

@RestController
@RequestMapping("/userInRoles")
public class UserInRoleController {

	@Autowired
	private UserInRoleService service;

	@GetMapping("/{roleName}/users")
	public ResponseEntity<List<User>> getUsersByRole(@PathVariable("roleName") String roleName) {
		return new ResponseEntity<List<User>>(service.getUsersByRole(roleName), HttpStatus.OK);
	}
}
