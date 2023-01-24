package com.te.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "category cannot be null")
	@Column(length = 100, nullable = false)
	private String category;
	
	@NotNull(message = "add description to enahance the detail")
	@Column(length = 300, nullable = false)
	private String description;
	
	@NotNull(message = "manufaturer us important")
	@Column(length = 50, nullable = false)
	private String manufacturer;
	
	@NotNull(message = "Name is very important")
	@Column(length = 50, nullable = false)
	private String name;
	
	@NotNull(message = "Enter price per unit")
	@Column(nullable = false)
	private Double price;
	
	@NotNull(message = "Please mention the total units in stock")
	@Column(nullable = false)
	private Integer unit;
	

}
