package com.te.ecommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer quantity;
	private Double price;

//	mapping to cart getting foreign key here
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_Id")
	private Cart cart;

//	mapping to product getting foreign key here
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id")
	private Product product;
}
