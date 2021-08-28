package com.ebmdev.users.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebmdev.users.entities.User;
import com.ebmdev.users.models.EbmdevSecurityRule;
import com.ebmdev.users.repositories.UserInRoleRepository;

@Service
@EbmdevSecurityRule // Esta anotación se aplicará a todos los métodos de la clase
public class UserInRoleService {

	@Autowired
	private UserInRoleRepository userInRoleRepository;

	private static final Logger log = LoggerFactory.getLogger(UserInRoleService.class);

	/**
	 * Utilizamos @RolesAllowed en caso de que pensamos que hay posibilidad de
	 * cambiar nuestra aplicación a algún otro framework que no sea spring, en caso
	 * de que sepamos que vamos a continuar con spring en nuestro proyecto
	 * usamos @Secured que es propia de spring.
	 */
	// @EbmdevSecurityRule - MetaAnotacion creada por nosotros que se hace efectiva
	// solo para el metodo que es marcado con ella
	public List<User> getUsersByRole(String roleName) {
		log.info("Getting roles by roleName = {}", roleName);
		return userInRoleRepository.findUsersByRoleName(roleName);
	}
}
