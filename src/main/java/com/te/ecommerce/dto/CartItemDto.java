package com.te.ecommerce.dto;

import com.te.ecommerce.entity.Cart;
import com.te.ecommerce.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

	private Integer id;
	private Integer quantity;
	private Double price;
	private Cart cart;
	private Product product;
}
