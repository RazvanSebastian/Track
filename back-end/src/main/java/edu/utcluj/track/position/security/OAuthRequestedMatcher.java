package edu.utcluj.track.position.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;

public class OAuthRequestedMatcher implements RequestMatcher {

	@Override
	public boolean matches(HttpServletRequest request) {
		return request.getHeader("Authorization").startsWith("Bearer");
	}

}