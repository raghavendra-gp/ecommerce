package com.te.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAllByCategory(String category);

	List<Product> findAllByName(String name);

	List<Product> findByName(String name);
//
//	List<ProductDto> findAll(String name);

}
