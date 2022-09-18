package com.example.demo.security;

import static com.example.demo.security.Constants.HEADER_AUTHORIZACION_KEY;
import static com.example.demo.security.Constants.ISSUER_INFO;
import static com.example.demo.security.Constants.SUPER_SECRET_KEY;
import static com.example.demo.security.Constants.TOKEN_BEARER_PREFIX;
import static com.example.demo.security.Constants.TOKEN_EXPIRATION_TIME;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.dto.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			Usuario credentials = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

			System.out.println(credentials.getAuthorities().toString());
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					credentials.getUsername(), credentials.getPassword(), credentials.getAuthorities()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String generateAccessToken(Usuario user) {
		
		final String authorities = user.getAuthorities().stream()
			.map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));
		
		return Jwts.builder()
			// Token Issuing Date
			.setIssuedAt(new Date())
			// Token Issuer (Us)
			.setIssuer(ISSUER_INFO)
			.claim("roles", authorities)
			// Subject for the Token (User who requested it)
			.setSubject(user.getUsername())
			// Expiration date for the token
			.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
			// What to sign the token with
			.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY)
			// Build and sign the token
			.compact();		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String JWTToken = generateAccessToken((Usuario) auth.getPrincipal());
		
		response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + JWTToken); // Token in header
		response.getWriter().write("{\"token\": \"" + JWTToken + "\"}"); // Token in body
		System.out.println(response.getHeader(HEADER_AUTHORIZACION_KEY));
	
	}
	
}
