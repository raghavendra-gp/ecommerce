package com.te.ecommerce.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AddProduct {

	private String category;
	private String description;
	private String manufacturer;
	private String name;
	private Double price;
	private Integer unit;
}
