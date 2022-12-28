package com.te.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateShippingAddress {
	
	private Integer id;
	private String address;
	private String city;
	private String state;
	private Long zipcode;
	private String country;
}
