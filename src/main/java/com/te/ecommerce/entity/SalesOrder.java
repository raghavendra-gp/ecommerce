package com.te.ecommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class SalesOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	getting foreign key of Cart in SalesOrder   (done)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;

//	getting foreign key of Customer in SalesOrder	(done)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;

//	getting foreign key of Shipping Address in SalesOrder	(done)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shippingAddress_id")
	private ShippingAddress shippingAddress;

//	getting foreign key of Billing Address in SalesOrder	(done)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billingAddress_id")
	private BillingAddress billingAddress;
}
