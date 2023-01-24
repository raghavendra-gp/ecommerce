package com.te.ecommerce.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

	@NotBlank(message = "Address cant be null")
	private String address;
	
	@NotBlank(message = "City cant be null")
	private String city;
	
	@NotBlank(message = "state cant be null")
	private String state;
	
	@NotNull(message = "zipcode is must")
	private Long zipcode;
	
	@NotBlank(message = "enter the country")
	private String country;
}
