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
public class ShippingAddressDto {
	
	@NotBlank(message = "address cant be null")
	private String address;
	
	@NotBlank(message = "city cant be null")
	private String city;
	
	@NotBlank(message = "state cant be null")
	private String state;
	
	@NotNull(message = "zipcode is must")
	private Long zipcode;
	
	@NotBlank(message = "country cant e null")
	private String country;

}
