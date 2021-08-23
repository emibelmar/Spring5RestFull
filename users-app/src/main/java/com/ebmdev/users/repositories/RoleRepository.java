package com.ebmdev.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebmdev.users.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
