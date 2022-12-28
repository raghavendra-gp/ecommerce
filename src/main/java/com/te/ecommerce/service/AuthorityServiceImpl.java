package com.te.ecommerce.service;

import java.util.List;
import java.util.Optional;

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
import com.te.ecommerce.exceptions.CustomerException;
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
//			if (presentProduct.getId().equals(productDto.getId())) {
//				if (productDto.getManufacturer() != null && !productDto.getManufacturer().isEmpty())
//					presentProduct.setManufacturer(productDto.getManufacturer());
//				if (productDto.getCategory() != null && !productDto.getCategory().isEmpty())
//					presentProduct.setCategory(productDto.getCategory());
//				if (productDto.getDescription() != null && !productDto.getDescription().isEmpty())
//					presentProduct.setDescription(productDto.getDescription());
//				if (productDto.getName() != null && !productDto.getName().isEmpty())
//					presentProduct.setName(productDto.getName());
//				if (productDto.getPrice().doubleValue()!=0)
//					presentProduct.setPrice(productDto.getPrice());
//				if (productDto.getUnit().intValue()!=0)
//					presentProduct.setUnit(productDto.getUnit());

//				productRepository.save(presentProduct);
			return productDto;

//			}else {
//				return null;
//			}
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
	public Optional<Customer> customerDetails(FindCustomer findCustomer) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(findCustomer, customer);
		Optional<Customer> customerById = customerRepository.findById(customer.getId());
		if (customerById != null) {
			return customerById;
		} else {
			throw new CustomerException("customer details not found");
		}
	}

}
