package com.example.records.demo.DemoApplication.handler;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	//根据身份前往不同的首页
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		HttpSession session = request.getSession();
		session.setAttribute("username", authentication.getName());
		if(roles.contains("ROLE_STUDENT")) {
			new DefaultRedirectStrategy().sendRedirect(request, response, "/studentIndex");
			return;
		}
		new DefaultRedirectStrategy().sendRedirect(request, response, "/teacherIndex");
		return;
	}
	
}
