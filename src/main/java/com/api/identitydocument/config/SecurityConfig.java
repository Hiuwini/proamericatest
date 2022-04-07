package com.api.identitydocument.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.api.identitydocument.generics.functions.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.api.identitydocument.repository")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger logger = LogManager.getLogger(SecurityConfig.class);
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("SpringSecurity configuration started");
		http.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and().cors()
					.and().csrf().disable()
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/auth").permitAll()
					.anyRequest().authenticated()
					.and().addFilter(new JWTAuthorizationFilter(authenticationManager(), getApplicationContext()));
		logger.info("SpringSecurity configuration ended");
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
	
}