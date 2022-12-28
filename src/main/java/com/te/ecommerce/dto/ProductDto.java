package com.te.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private Integer id;
	private String category;
	private String description;
	private String manufacturer;
	private String name;
	private Double price;
	private Integer unit;
}
