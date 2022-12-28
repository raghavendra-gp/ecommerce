package com.te.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BillingAddressDto {

	private String address;
	private String city;
	private String state;
	private Long zipcode;
	private String country;
}
