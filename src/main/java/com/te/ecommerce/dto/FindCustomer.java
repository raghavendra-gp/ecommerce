package com.te.ecommerce.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FindCustomer {
	
	@NotBlank(message = "enter phone number to search")
	private String customerPhone;

}
