package com.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter { 
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
			// Define url's that require authentication
			.antMatchers("/addCustomer", "/addProduct", "/addOrder", "/showCustomers", "/showProducts", "/showOrders")
			.hasRole("USER")
			.and()
			.formLogin()
			.and()
			.logout()
			// Define the url to use to logout
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			// Define the url to go to after logout
			.logoutSuccessUrl("/");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Create a user with a username and password of "user" and the role "USER"
		auth.inMemoryAuthentication()
			.withUser("user").password("user").roles("USER");
	}
}