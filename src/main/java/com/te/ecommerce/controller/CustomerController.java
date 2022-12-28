package com.te.ecommerce.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.te.ecommerce.dto.BillingAddressDto;
import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.CustomerDetDto;
import com.te.ecommerce.dto.DeleteBillingAddress;
import com.te.ecommerce.dto.DeleteShippingAddress;
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.dto.ProductOrder;
import com.te.ecommerce.dto.ProductUnit;
import com.te.ecommerce.dto.SearchByCategory;
import com.te.ecommerce.dto.SearchByName;
import com.te.ecommerce.dto.ShippingAddressDto;
import com.te.ecommerce.dto.UpdateBillingAddress;
import com.te.ecommerce.dto.UpdateShippingAddress;
import com.te.ecommerce.response.AppResponse;
import com.te.ecommerce.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AppResponse appResponse;

//	Search A Product By Category
	@PostMapping("/searchCategory")
	private ResponseEntity<AppResponse> searchCategory(@RequestBody SearchByCategory searchByCategory) {
		List<ProductDto> searchCategory = customerService.searchCategory(searchByCategory);
		if (searchCategory != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(searchCategory));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Search A Product By Name
	@PostMapping("/searchName")
	private ResponseEntity<AppResponse> searchName(@RequestBody SearchByName searchByName) {
		List<ProductDto> searchName = customerService.searchName(searchByName);
		if (searchName != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(searchName));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Sort the product based on price of category (low to high)
	@PostMapping("/sortCategoryPriceLowToHigh")
	private ResponseEntity<AppResponse> sortByPriceLowToHigh(@RequestBody SearchByCategory searchByCategory) {
		List<ProductDto> sortByPriceLowToHigh = customerService.sortByPriceLowToHigh(searchByCategory);
		if (sortByPriceLowToHigh != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(sortByPriceLowToHigh));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}

	}

//	Sort the product based on price of category (high to low)
	@PostMapping("/sortCategoryPriceHighToLow")
	private ResponseEntity<AppResponse> sortByPriceHighToLow(@RequestBody SearchByCategory searchByCategory) {
		List<ProductDto> sortByPriceHighToLow = customerService.sortByPriceHighToLow(searchByCategory);
		if (sortByPriceHighToLow != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(sortByPriceHighToLow));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Sort the product based on price of name (low to high)
	@PostMapping("/sortNamePriceLowToHigh")
	private ResponseEntity<AppResponse> sortByNamePriceLowToHigh(@RequestBody SearchByName searchByName) {
		List<ProductDto> sortByNamePriceLowToHigh = customerService.sortByNamePriceLowToHigh(searchByName);
		if (sortByNamePriceLowToHigh != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(sortByNamePriceLowToHigh));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Sort the product based on price of name (high to low)
	@PostMapping("/sortNamePriceHighToLow")
	private ResponseEntity<AppResponse> sortByNamePriceHighToLow(@RequestBody SearchByName searchByName) {
		List<ProductDto> sortByNamePriceHighToLow = customerService.sortByNamePriceHighToLow(searchByName);
		if (sortByNamePriceHighToLow != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(sortByNamePriceHighToLow));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}

	}

//	sort Category Alphabet Ascending
	@PostMapping("/sortCategoryAlphabetAscending")
	private ResponseEntity<AppResponse> sortCategoryAlphabetAscending(@RequestBody SearchByCategory searchByCategory) {
		List<ProductDto> sortCategoryAlphabetAscending = customerService
				.sortCategoryAlphabetAscending(searchByCategory);
		if (sortCategoryAlphabetAscending != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(sortCategoryAlphabetAscending));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}

	}

//	sort Category Alphabet Descending
	@PostMapping("/sortCategoryAlphabetDescending")
	private ResponseEntity<AppResponse> sortCategoryAlphabetDescending(@RequestBody SearchByCategory searchByCategory) {
		List<ProductDto> sortCategoryAlphabetDescending = customerService
				.sortCategoryAlphabetDescending(searchByCategory);
		if (sortCategoryAlphabetDescending != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(sortCategoryAlphabetDescending));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}

	}

//	Sort the Products based on name alphabetically (a-z)
	@PostMapping("/sortNameAlphabetAscending")
	private ResponseEntity<AppResponse> sortNameAlphabetAscending(@RequestBody SearchByName searchByName) {
		List<ProductDto> sortNameAlphabetAscending = customerService.sortNameAlphabetAscending(searchByName);
		if (sortNameAlphabetAscending != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(sortNameAlphabetAscending));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Sort the Products based on name alphabetically (z-a)
	@PostMapping("/sortNameAlphabetDescending")
	private ResponseEntity<AppResponse> sortNameAlphabetDescending(@RequestBody SearchByName searchByName) {
		List<ProductDto> sortNameAlphabetDescending = customerService.sortNameAlphabetDescending(searchByName);
		if (sortNameAlphabetDescending != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(sortNameAlphabetDescending));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Adding Billing Address of Customer
	@PostMapping("/addBillingAddress/{Id}")
	private ResponseEntity<AppResponse> billingAddress(@PathVariable Integer Id,  @RequestBody BillingAddressDto addressDto) {
		BillingAddressDto billingAddress = customerService.billingAddress(addressDto, Id);
		if (billingAddress != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(billingAddress));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}

	}

//	Update Billing Address of Customer
	@PutMapping("/updateBillingAddress")
	private ResponseEntity<AppResponse> updateBillingAddress(@RequestBody UpdateBillingAddress updateBillingAddress) {
		UpdateBillingAddress updateBillingAddress2 = customerService.updateBillingAddress(updateBillingAddress);
		if (updateBillingAddress2 != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(updateBillingAddress2));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Deleting Billing Address of Customer
	@DeleteMapping("/deleteBillingAddress")
	private ResponseEntity<AppResponse> deleteBillingAddress(@RequestBody DeleteBillingAddress deleteBillingAddress) {
		String deleteBillingAddressMsg = customerService.deleteBillingAddress(deleteBillingAddress);
		if (deleteBillingAddressMsg != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(deleteBillingAddressMsg));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Adding Shipping Address of Customer
	@PostMapping("/addShippingAddress/{Id}")
	private ResponseEntity<AppResponse> shippingAddress(@PathVariable Integer Id, @RequestBody ShippingAddressDto shippingAddressDto) {
		ShippingAddressDto shippingAddress = customerService.shippingAddress(shippingAddressDto, Id);
		if (shippingAddress != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(shippingAddress));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Updating Shipping Address of Customer
	@PutMapping("/updateShippingAddress")
	private ResponseEntity<AppResponse> updateShippingAddress(
			@RequestBody UpdateShippingAddress updateShippingAddress) {
		UpdateShippingAddress updatedShippingAddress = customerService.updateShippingAddress(updateShippingAddress);
		if (updatedShippingAddress != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(updatedShippingAddress));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	Updating Shipping Address of Customer
	@DeleteMapping("/deleteShippingAddress")
	private ResponseEntity<AppResponse> deleteShippingAddress(
			@RequestBody DeleteShippingAddress deleteShippingAddress) {
		String address = customerService.deleteShippingAddress(deleteShippingAddress);
		if (address != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(address));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}

//	getting both shipping and billing addresses
	@SuppressWarnings("rawtypes")
	@PostMapping("/allAddresses/{Id}")
	private ResponseEntity<AppResponse> allAddresses(@PathVariable Integer Id) {
		List allAddresses = customerService.allAddresses(Id);
		if (allAddresses != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(allAddresses));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}
	
//	Adding item to cart
	@PostMapping("/addToCart/{Id}/{productUnit}")
	private ResponseEntity<AppResponse> addToCart(@PathVariable Integer Id, @PathVariable Integer productUnit, @RequestBody ProductOrder productOrder) {
		CartItemDto addedToCart = customerService.addToCart(Id, productOrder, productUnit);
		if (addedToCart != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(addedToCart));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfull");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NO_CONTENT);
		}
	}
}
