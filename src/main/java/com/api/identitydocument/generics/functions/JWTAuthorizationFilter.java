package com.api.identitydocument.generics.functions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.api.identitydocument.generics.types.IAuthorizationTypes;
import com.api.identitydocument.generics.types.ISetupTypes;
import com.api.identitydocument.repository.intf.ISetupRepository;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
		
	private ISetupRepository setup;
	
	private String userId;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, ApplicationContext ctx) {
		super(authenticationManager);
		this.setup = ctx.getBean(ISetupRepository.class);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			String header = request.getHeader(IAuthorizationTypes.header);
			if (isToken(header)) {
				setupAuth(header);
			}else {
				SecurityContextHolder.clearContext();
			}
			chain.doFilter(request, response);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
			return;
		}
	}	

	private void setupAuth(String token) {		
		UsernamePasswordAuthenticationToken auth = getAuthentication(token);
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication(String token) {
		if (token != null) {
			String secret = setup.findItemByKeyName(ISetupTypes.jwt_keyName).getKeyValue();
			this.userId = (String)Jwts.parser().setSigningKey(secret.getBytes())
									   .parseClaimsJws(token.replace(IAuthorizationTypes.bearerType + " ", ""))
									   .getBody()
									   .get("client");

			if (userId != null) {
				return new UsernamePasswordAuthenticationToken(userId, null, new ArrayList<>());
			}
			return null;
		}
		return null;
	}

	private boolean isToken(String authHeader) {
		if (authHeader == null || !authHeader.startsWith(IAuthorizationTypes.bearerType))
			return false;
		return true;
	}

}
