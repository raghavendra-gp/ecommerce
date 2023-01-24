package com.te.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecommerce.dto.AddProduct;
import com.te.ecommerce.dto.DeleteProduct;
import com.te.ecommerce.dto.FindCustomer;
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.dto.ProductReload;
import com.te.ecommerce.dto.SalesOrderId;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.entity.SalesOrder;
import com.te.ecommerce.exceptions.ProductException;
import com.te.ecommerce.exceptions.ProductNotFoundException;
import com.te.ecommerce.exceptions.SalesOrderException;
import com.te.ecommerce.exceptions.SalesOrderNotFoundException;
import com.te.ecommerce.repository.CustomerRepository;
import com.te.ecommerce.repository.ProductRepository;
import com.te.ecommerce.repository.SalesOrderRepository;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SalesOrderRepository salesOrderRepository;

	@Autowired
	private CustomerRepository customerRepository;

//	Adding a Product
	@Override
	public AddProduct addProduct(AddProduct addProduct) {
		Product product = new Product();
		BeanUtils.copyProperties(addProduct, product);
		productRepository.save(product);

		return addProduct;
	}

//	Deleting a Product
	@Override
	public ProductReload deleteProduct(DeleteProduct deleteProduct) {
		Product product = new Product();
		ProductReload productReload = new ProductReload();
		BeanUtils.copyProperties(deleteProduct, product);
		Product presentProduct = productRepository.findById(product.getId()).orElseThrow(ProductNotFoundException::new);
		if (presentProduct != null) {
			productRepository.deleteById(product.getId());
			productReload.setManufacturer(presentProduct.getManufacturer());
			productReload.setCategory(presentProduct.getCategory());
			productReload.setName(presentProduct.getName());
			return productReload;
		} else {
			throw new ProductException("Product deletion is not possible at the moment");
		}

	}

//	Modifying a Product
	@Override
	public ProductDto modifyProduct(ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		Product presentProduct = productRepository.findById(product.getId()).orElseThrow(ProductNotFoundException::new);
		if (presentProduct != null) {
			productRepository.save(product);
			return productDto;

		} else {
			throw new ProductException("Updating product unsucessfull");
		}
	}

//	List Of All the SalesOrders
	@Override
	public List<SalesOrder> allSalesOrder() {
		return salesOrderRepository.findAll();
	}

//	Getting individual Sales Order
	@Override
	public SalesOrder individualSalesOrder(SalesOrderId orderId) {
		SalesOrder salesOrder = new SalesOrder();
		BeanUtils.copyProperties(orderId, salesOrder);

		SalesOrder salesOfOrder = salesOrderRepository.findById(salesOrder.getId())
				.orElseThrow(SalesOrderNotFoundException::new);
		if (salesOfOrder != null) {
			return salesOfOrder;
		} else {
			throw new SalesOrderException("No sales order found");
		}
	}

//	Find the Customer
	@Override
	public Optional<Customer> customerDetails(@NotNull FindCustomer findCustomer) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(findCustomer, customer);
		return customerRepository.findById(customer.getId());

	}
}
