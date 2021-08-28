package com.ebmdev.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
/**
 * securedEnabled = true pasamos este parametro para poder usar @Secured
 * jsr250Enabled = true pasamos este parametro para poder usar @RolesAllowed
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Comentamos este método para la autenticación desde base de datos en memoria
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throw
	 *           Exception {
	 *           auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("password")).roles("ADMIN").and()
	 *           .withUser("user").password(encoder().encode("password")).roles("USER");
	 *           }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/users/**").hasRole("ADMIN").antMatchers("/roles/**")
				.authenticated().antMatchers("/userInRoles/**").authenticated().anyRequest().authenticated().and()
				.httpBasic();
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();

	}

}
