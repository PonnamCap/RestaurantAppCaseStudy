package com.cg.service;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cg.utils.JwtUtils;
//@Component
@Service
public class JwtFilterRequest extends OncePerRequestFilter {
@Autowired
private JwtUtils jwtutils;
@Autowired
private UserService userService;

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
throws ServletException, IOException {
	
// TODO Auto-generated method stub
String authorizationHeader = request.getHeader("Authorization");

String username = null;

String jwtToken=null;

if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
	
jwtToken = authorizationHeader.substring(7);
username= jwtutils.extractUsername(jwtToken);

}

if( username != null && SecurityContextHolder.getContext().getAuthentication()== null) {
UserDetails currentUserDetails = userService.loadUserByUsername(username);
Boolean tokenvalidated= jwtutils.validateToken(jwtToken, currentUserDetails );

if(tokenvalidated) {
UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
		currentUserDetails,null ,currentUserDetails.getAuthorities());
usernamePasswordAuthenticationToken
        .setDetails(new WebAuthenticationDetailsSource()
		.buildDetails(request));
SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
}
}
filterChain.doFilter(request, response);
}

}
