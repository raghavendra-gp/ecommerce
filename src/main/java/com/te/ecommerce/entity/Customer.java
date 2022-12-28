package com.te.ecommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 13)
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
