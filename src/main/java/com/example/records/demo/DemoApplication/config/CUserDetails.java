package com.example.records.demo.DemoApplication.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.records.demo.DemoApplication.entity.CUser;

public class CUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8662475424531083189L;

	CUser cuser;
	
	
	public CUserDetails() {
		super();
	}

	public CUserDetails(CUser cuser) {
		this.cuser = cuser;
	}

	
	//获取权限（身份）
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		String roles = cuser.getRoles();
		String[] role = roles.split(",");
		for(String r : role) {
			auths.add(new SimpleGrantedAuthority(r));
		}
		return auths;
	}

	@Override
	public String getPassword() {
		return cuser.getPassword();
	}

	@Override
	public String getUsername() {
		return cuser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return cuser.getActive();
	}

}
