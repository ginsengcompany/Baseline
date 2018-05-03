package it.baseline.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
	  	.antMatchers("/").permitAll()
		.antMatchers("/dashboard").permitAll()
	  	.antMatchers("/dashboard/**").access("hasRole('MMG')")
	  	.and().formLogin().loginPage("/")
	  	.usernameParameter("ssoId").passwordParameter("password")
	  	.and().csrf()
		.and().formLogin().failureUrl("/loginError")
        .and().formLogin().defaultSuccessUrl("/dashboard")
	  	.and().exceptionHandling().accessDeniedPage("/accessDeniedPage");
	}
}
