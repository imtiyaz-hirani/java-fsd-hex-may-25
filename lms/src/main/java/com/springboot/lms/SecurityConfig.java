package com.springboot.lms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //<- This ensures that this class gets called during every API call
public class SecurityConfig {
	
	@Bean
	UserDetailsService users() {
		UserDetails user = User.builder()
			.username("user")
			.password("{noop}user123")
			.roles("USER")
			.build();
		UserDetails admin = User.builder()
			.username("admin")
			.password("{noop}admin123")
			.roles("ADMIN")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
				.anyRequest().authenticated()  
			)
		 .httpBasic(Customizer.withDefaults()); //<- this activated http basic technique
		return http.build();
	}
}
