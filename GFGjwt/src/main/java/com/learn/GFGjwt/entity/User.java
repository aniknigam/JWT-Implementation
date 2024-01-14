package com.learn.GFGjwt.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@Getter
@Setter
public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
	    
	    @Column(name = "user_name", nullable = false, length = 100)   
		private String name;
	    
	    @Column
		private String email;
	    
	    private String roles;
	    
	    @Column
		private String password;
	    
	 
}
