package com.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rest.customuserdetailsservice.CustomUserDetailService;
import com.rest.filter.JwtAuthenticationFilter;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class AirlinePassengerConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	CustomUserDetailService cds;
	
	@Autowired
	JwtAuthenticationFilter jwtFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable().cors()
			.disable()
			.authorizeHttpRequests()
			.antMatchers("/airlines").permitAll()
			.antMatchers("/passengers/**").hasRole("ADMIN")
			.antMatchers("/passengers").hasRole("ADMIN")
			.antMatchers("/airlines/**").hasRole("NORMAL")
			.antMatchers("/signin").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(cds).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
	return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
	return super.authenticationManager();
	}



}
