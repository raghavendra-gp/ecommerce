package com.te.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddressDto {
	
	private String address;
	private String city;
	private String state;
	private Long zipcode;
	private String country;

}
