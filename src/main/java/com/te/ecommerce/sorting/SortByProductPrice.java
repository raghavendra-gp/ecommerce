package com.te.ecommerce.sorting;

import java.util.Comparator;

import com.te.ecommerce.entity.Product;

public class SortByProductPrice implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return (int) (o1.getPrice()-o2.getPrice());
	}

}
