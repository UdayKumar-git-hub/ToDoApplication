package com.todoapp.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager()
	{
		
		UserDetails userDetails = createNewUser("UdayKumar","pass");
		UserDetails userDetails1 = createNewUser("Amulya","ammu");
		UserDetails userDetails2 = createNewUser("Dhanya","doreamon");
		UserDetails userDetails3 = createNewUser("pavan","pass");
		
		return new InMemoryUserDetailsManager(userDetails,userDetails1,userDetails2,userDetails3);
		
	}

	public UserDetails createNewUser(String username, String password) {
		Function<String, String> passEncoder
		 = input -> pEncoder().encode(input);
		 
		
		UserDetails userDetails = User.builder()
												.passwordEncoder(passEncoder)
												.username(username)
												.password(password)
												.roles("USER","ADMIN")
												.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder pEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	//All http requests must be authenticated
	//Login page should be shown for unauthorized requests
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception
	{
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
		
	}
	
}
