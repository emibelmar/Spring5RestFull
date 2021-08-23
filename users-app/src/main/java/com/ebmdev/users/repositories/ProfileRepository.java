package com.ebmdev.users.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ebmdev.users.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {

}
