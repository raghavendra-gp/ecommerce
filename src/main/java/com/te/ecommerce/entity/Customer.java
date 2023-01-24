package com.te.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50,nullable = false)
	private String firstName;
	
	@Column(length = 50,nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String password;
	
	@Column(length = 13,nullable = false, unique = true)
	private Long customerPhone;

//	getting foreign key of ShippingAddress in Customer
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddress shippingAddress;

//	getting foreign key of Billing Address in Customer
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;

//	getting foreign key of User in Customer
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;

//	getting foreign key of Cart in Customer
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId")
	private Cart cart;

}
