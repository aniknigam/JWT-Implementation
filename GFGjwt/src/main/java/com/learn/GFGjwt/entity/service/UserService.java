package com.learn.GFGjwt.entity.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.learn.GFGjwt.entity.User;

import com.learn.GFGjwt.repository.UserRepo;




@Service
public class UserService implements UserDetailsService  {
	    @Autowired
	    private UserRepo userRepo;
	    
	  
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<User> userInfo = userRepo.findByName(username);
	        return userInfo.map(UserDetail::new)
	                .orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
	    }
	    
	    public String addUser(User userInfo){
	        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
	        userRepo.save(userInfo);
	        return "User added successfully";
	    }
	    public List<User> getAllUser(){
	         return userRepo.findAll();
	    }
	    public User getUser(Integer id){
	        return userRepo.findById(id).get();
	    }

}
