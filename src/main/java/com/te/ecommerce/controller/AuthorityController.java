package com.te.ecommerce.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.te.ecommerce.dto.AddProduct;
import com.te.ecommerce.dto.DeleteProduct;
import com.te.ecommerce.dto.FindCustomer;
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.dto.ProductReload;
import com.te.ecommerce.dto.SalesOrderId;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.SalesOrder;
import com.te.ecommerce.response.AppResponse;
import com.te.ecommerce.service.AuthorityService;

@Controller
@RequestMapping("/authority")
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private AppResponse appResponse;

//	Addition Of Product By the Authority
	@PostMapping("/addProduct")
	private ResponseEntity<AppResponse> addProduct(@RequestBody AddProduct addProduct) {
		AddProduct product = authorityService.addProduct(addProduct);
		if (product != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(product));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}

	}

//	Deletion Of The Product By The Authority
	@DeleteMapping("/deleteProduct")
	private ResponseEntity<AppResponse> deleteProduct(@RequestBody DeleteProduct deleteProduct) {
		ProductReload productReload = authorityService.deleteProduct(deleteProduct);
		if (productReload != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(productReload));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(201);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Modifiaction OF The Product By The Authority
	@PutMapping("/modifyProduct")
	private ResponseEntity<AppResponse> modifyProduct(@RequestBody ProductDto productDto) {
		ProductDto product = authorityService.modifyProduct(productDto);
		if (product != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(product));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(201);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	List of All The Sales Orders
	@GetMapping("/allSalesOrder")
	private ResponseEntity<AppResponse> allSalesOrder() {
		List<SalesOrder> allSalesOrder = authorityService.allSalesOrder();
		if (allSalesOrder != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(allSalesOrder));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(201);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Individual Sales Orders
	@PostMapping("/getIndividualSalesOrder")
	private ResponseEntity<AppResponse> individualSalesOrder(@RequestBody SalesOrderId orderId) {
		SalesOrder individualSalesOrder = authorityService.individualSalesOrder(orderId);
		if (individualSalesOrder != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(individualSalesOrder));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(201);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Individual Customer Details
	@PostMapping("/customerById")
	private ResponseEntity<AppResponse> customerDetails(@RequestBody FindCustomer findCustomer) {
		Optional<Customer> customerDetails = authorityService.customerDetails(findCustomer);
		if (customerDetails != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(customerDetails));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(201);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}

	}
}
