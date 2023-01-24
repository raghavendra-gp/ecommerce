package com.te.ecommerce.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {
	
	@NotNull(message = "id is must")
	private Integer id;
	
	@NotNull(message = "enter the quantity")
	private Integer quantity;
	
	@NotNull(message = "customer id is must")
	private Integer custId;

}
