package com.ebmdev.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ebmdev.users.entities.Address;
import com.ebmdev.users.entities.Profile;
import com.ebmdev.users.repositories.AddressRepository;
import com.ebmdev.users.repositories.ProfileRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ProfileRepository profileRepository;

	public List<Address> findAddressesByProfileIdAndUserId(Integer userId, Integer profileId) {
		return addressRepository.findByProfileId(userId, profileId);
	}

	public Address createAddress(Integer userId, Integer profileId, Address address) {
		Optional<Profile> profile = profileRepository.findByUserIdAndProfileId(userId, profileId);

		if (profile.isPresent()) {
			address.setProfile(profile.get());
			return addressRepository.save(address);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("Profile with id %d and User with id %d not found", profileId, userId));

		}
	}
}
