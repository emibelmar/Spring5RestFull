package com.ebmdev.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebmdev.users.entities.Address;
import com.ebmdev.users.services.AddressService;

@RestController
@RequestMapping("/users/{userId}/profiles/{profileId}/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping
	public ResponseEntity<List<Address>> findAddressesByProfileIdAndUserId(@PathVariable Integer userId,
			@PathVariable Integer profileId) {
		return new ResponseEntity<List<Address>>(addressService.findAddressesByProfileIdAndUserId(userId, profileId),
				HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Address> create(@PathVariable Integer userId, @PathVariable Integer profileId,
			@RequestBody Address address) {
		return new ResponseEntity<Address>(addressService.createAddress(userId, profileId, address),
				HttpStatus.CREATED);
	}
}
