package com.ibm.OrderProcessService.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ibm.OrderProcessService.service.*;

@EnableWebSecurity
public class SecurityConfigurer  extends WebSecurityConfigurerAdapter{


	@Autowired
	private MyUserDetailsService myuserDetailsService;

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(myuserDetailsService);
	super.configure(auth);
	}
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	        .antMatchers("/").permitAll()
	                                     
	        .antMatchers("/admin/**").hasRole("ADMIN")
	          .and()
	        .csrf().disable() 
	        .headers().frameOptions().disable()
	          .and()
	        .formLogin();
	  }
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
