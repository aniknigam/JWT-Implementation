package com.learn.GFGjwt.entity.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.lang.String;


import com.learn.GFGjwt.entity.User;


public class UserDetail implements UserDetails {
    String userName=null;
    String password = null;
    List<GrantedAuthority> authorities;//GrantedAuthority is an interface provided by Spring Security. It represents an authority or a role assigned to a user

    public UserDetail(User userInfo) {
    	  userName= userInfo.getName();
          password= userInfo.getPassword();
          authorities= Arrays.stream(userInfo.getRoles().split(","))
                  .map(SimpleGrantedAuthority::new)//SimpleGrantedAuthority is designed to represent a granted authority or role for a user in a Spring Security context.
                  .collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return true;
    }
}

