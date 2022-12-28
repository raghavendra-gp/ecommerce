package com.te.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderDto {

	private Integer id;

	private Integer cartId;

	private Integer customerId;

	private Integer shippingAddressId;

	private Integer billingAddressId;
}
