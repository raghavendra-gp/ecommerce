package com.te.ecommerce.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class AddProduct {

	@NotBlank(message = "category cannot be null")
	private String category;

	@NotBlank(message = "add description to enahance the detail")
	private String description;

	@NotBlank(message = "manufaturer us important")
	private String manufacturer;

	@NotBlank(message = "Name is very important")
	private String name;

	@NotNull(message = "Enter price per unit")
	private Double price;

	@NotNull(message = "Please mention the total units in stock")
	private Integer unit;
}
