package com.rest.customuserdetailsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rest.customuserdetail.CustomUserDetail;
import com.rest.model.User;
import com.rest.repo.UserRepo;

@Service
public class CustomUserDetailService  implements UserDetailsService{

	@Autowired
	UserRepo ur;
	
	public UserRepo getUr() {
		return ur;
	}

	public void setUr(UserRepo ur) {
		this.ur = ur;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User up=ur.findByUsername(username);
		return new CustomUserDetail(up);

	}

}
