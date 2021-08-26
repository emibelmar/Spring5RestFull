package com.ebmdev.users.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebmdev.users.entities.User;
import com.ebmdev.users.entities.UserInRole;

@Repository
public interface UserInRoleRepository extends CrudRepository<UserInRole, Integer> {

	@Query("SELECT u.user FROM UserInRole u WHERE u.role.name = ?1")
	public List<User> findUsersByRoleName(String roleName);

	public List<UserInRole> findByUser(User user);
}
