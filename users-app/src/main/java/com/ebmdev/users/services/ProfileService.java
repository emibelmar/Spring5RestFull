package com.ebmdev.users.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ebmdev.users.entities.Profile;
import com.ebmdev.users.entities.User;
import com.ebmdev.users.repositories.ProfileRepository;
import com.ebmdev.users.repositories.UserRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private UserRepository userRepository;

	public Profile createProfile(Integer userId, Profile profile) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			profile.setUser(user.get());
			return profileRepository.save(profile);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", userId));
		}
	}

	public Profile getByUserIdAndProfileId(Integer userId, Integer profileId) {
		return profileRepository.findByUserIdAndProfileId(userId, profileId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Profile not found for userId %d and profileId %d", userId, profileId)));
	}
}
