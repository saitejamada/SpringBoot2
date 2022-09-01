package com.rest.filter;

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
import org.springframework.web.filter.OncePerRequestFilter;

import com.rest.customuserdetailsservice.CustomUserDetailService;
import com.rest.helper.JwtTokenUtil;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

@Autowired
 JwtTokenUtil jwtUtil;

@Autowired
 CustomUserDetailService cs;

public JwtTokenUtil getJwtUtil() {
	return jwtUtil;
}


public void setJwtUtil(JwtTokenUtil jwtUtil) {
	this.jwtUtil = jwtUtil;
}

public CustomUserDetailService getCs() {
	return cs;
}

public void setCs(CustomUserDetailService cs) {
	this.cs = cs;
}


@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
FilterChain filterChain)
throws ServletException, IOException {
// TODO Auto-generated method stub

String requestTokenHeader=request.getHeader("Authorization");
String username=null;
String jwtToken=null;

if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer"))
{
jwtToken=requestTokenHeader.substring(7);

try
{
username=this.jwtUtil.getUsernameFromToken(jwtToken);
}
catch(Exception e)
{
e.printStackTrace();
}
}

UserDetails userDetails=this.cs.loadUserByUsername(username);

//Security

if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
{

UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
}
else
{
	System.out.println("Token Not Validated");
}



filterChain.doFilter(request, response);
}



}