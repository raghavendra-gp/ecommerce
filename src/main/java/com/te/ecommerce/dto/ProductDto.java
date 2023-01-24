package com.te.ecommerce.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	@NotNull(message = "id is must")
	private Integer id;
	
	@NotBlank(message = "category cant be null")
	private String category;
	
	@NotBlank(message = "descrption is mandatory")
	private String description;
	
	@NotBlank(message = "manufacturer is must")
	private String manufacturer;
	
	@NotBlank(message = "product name is must")
	private String name;
	
	@NotNull(message = "price of unit is must")
	private Double price;
	
	@NotNull(message = "enter the units available")
	private Integer unit;
}
