package com.te.ecommerce.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
import com.te.ecommerce.exceptions.ProductException;
import com.te.ecommerce.response.AppResponse;
import com.te.ecommerce.service.AuthorityService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/authority")
@PreAuthorize(value = "hasRole('ADMIN')")
@RequiredArgsConstructor
public class AuthorityController {

	private final AuthorityService authorityService;

	private static final String SUCCESS = "Sucessfully Added";
	private static final String FAIL = "Unsucessfull";

//	Addition Of Product By the Authority
	@PostMapping("/addProduct")
	public ResponseEntity<AppResponse> addProduct(@RequestBody @Valid AddProduct addProduct, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			throw new ProductException("Enter all the fields");
		}
		else {
			AddProduct product = authorityService.addProduct(addProduct);
			if (product != null) {
				return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS).data(Arrays.asList(product))
						.status(200).build(), HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
						HttpStatus.BAD_REQUEST);
			}
		}
		

	}

//	Deletion Of The Product By The Authority
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<AppResponse> deleteProduct(@RequestBody @Valid DeleteProduct deleteProduct) {
		ProductReload productReload = authorityService.deleteProduct(deleteProduct);
		if (productReload != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(productReload)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Modifiaction OF The Product By The Authority
	@PutMapping("/modifyProduct")
	public ResponseEntity<AppResponse> modifyProduct(@RequestBody @Valid ProductDto productDto) {
		ProductDto product = authorityService.modifyProduct(productDto);
		if (product != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS).data(Arrays.asList(product))
					.status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	List of All The Sales Orders
	@GetMapping("/allSalesOrder")
	public ResponseEntity<AppResponse> allSalesOrder() {
		List<SalesOrder> allSalesOrder = authorityService.allSalesOrder();
		if (allSalesOrder != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(allSalesOrder)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Individual Sales Orders
	@PostMapping("/getIndividualSalesOrder")
	public ResponseEntity<AppResponse> individualSalesOrder(@RequestBody @Valid SalesOrderId orderId) {
		SalesOrder individualSalesOrder = authorityService.individualSalesOrder(orderId);
		if (individualSalesOrder != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(individualSalesOrder)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Individual Customer Details
	@PostMapping("/customerById")
	public ResponseEntity<AppResponse> customerDetails(@RequestBody @Valid FindCustomer findCustomer) {
		Optional<Customer> customerDetails = authorityService.customerDetails(findCustomer);

		return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
				.data(Arrays.asList(customerDetails)).status(200).build(), HttpStatus.ACCEPTED);

	}
}
