package com.example.records.demo.DemoApplication.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.records.demo.DemoApplication.entity.CUser;
import com.example.records.demo.DemoApplication.repository.UserRepository;

@Service
public class CUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository userRepo;

	//登录验证
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<CUser> optUser = userRepo.findByUsername(username);
		CUser user = optUser.orElseThrow(()->{
			throw new UsernameNotFoundException("USER NOT FOUND");
		});
		return new CUserDetails(user);
	}
	
	
}
