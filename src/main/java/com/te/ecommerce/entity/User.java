package com.te.ecommerce.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String userName;
	
	@Column(length = 50)
	private String emailid;
	
//	@Column(length = 50)
	private String password;
	
	private boolean enabled;
		
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "rolestable", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "role")
	private Set<String> roles;
}
