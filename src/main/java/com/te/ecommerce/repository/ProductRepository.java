package com.te.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<ProductDto> findAllByCategory(String category);

	List<ProductDto> findAllByName(String name);

	List<ProductDto> findByName(String name);
//
//	List<ProductDto> findAll(String name);

}
