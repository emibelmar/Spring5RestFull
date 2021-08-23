package com.ebmdev.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebmdev.users.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
