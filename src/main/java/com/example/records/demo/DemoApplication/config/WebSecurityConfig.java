package com.example.records.demo.DemoApplication.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.records.demo.DemoApplication.handler.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource datasource;
	
	@Autowired
	CUserDetailsService userDetailsService;
	
	//权限获取
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage("/login.html")
			.loginProcessingUrl("/login")
			.successHandler(new LoginSuccessHandler());
			//.successForwardUrl("/index");
		http.logout()
			.logoutSuccessUrl("/login.html");
		http.authorizeRequests()
			.antMatchers("/assets/**","/css/**","/js/**","/images/**").permitAll()
			.antMatchers("/teacher/**","/student/**").permitAll()
			.antMatchers("/login.html").permitAll()
			.antMatchers("/regist").permitAll()
			.antMatchers("/").permitAll()
			
			
			
			.anyRequest()
			.authenticated();
		http.logout().permitAll();
		//关闭csrf防护
		http.csrf().disable();
		//允许SpringSecurity 加载同源的 iframe
		http.headers().frameOptions().sameOrigin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance();
	}
}
