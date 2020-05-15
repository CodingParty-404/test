package org.zerock.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class MemberVO implements UserDetails{

	private String userid;
	private String userpw;
	private String username;
	private boolean enabled;
	
	private List<AuthVO> authList;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authList.stream().
				map(authVO -> new SimpleGrantedAuthority(authVO.getAuth())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.userpw;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userid;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
}
