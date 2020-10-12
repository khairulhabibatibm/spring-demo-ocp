package org.acme.demoocp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.security.SecurityProperties;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class DemoOcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOcpApplication.class, args);
	}

	// @Configuration
	// protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	// 	@Override
	// 	protected void configure(HttpSecurity http) throws Exception {
	// 	http
	// 		.httpBasic()
	// 	.and()
	// 		.authorizeRequests()
	// 		.antMatchers("/index.html", "/", "/home", "/login","/api").permitAll();
	// 	http.csrf().disable();
	// 	http.cors().disable();
	// 	}
  	// }

}
