package com.te.ecommerce.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.dto.BillingAddressDto;
import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.DeleteBillingAddress;
import com.te.ecommerce.dto.DeleteShippingAddress;
import com.te.ecommerce.dto.ProductOrder;
import com.te.ecommerce.dto.SearchByCategory;
import com.te.ecommerce.dto.SearchByName;
import com.te.ecommerce.dto.ShippingAddressDto;
import com.te.ecommerce.dto.UpdateBillingAddress;
import com.te.ecommerce.dto.UpdateShippingAddress;
import com.te.ecommerce.entity.CartItem;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.response.AppResponse;
import com.te.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/customer")
@PreAuthorize(value = "hasAnyRole('CUSTOMER','ADMIN')")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

//	@Autowired
//	private AppResponse appResponse;

	private static final String SUCCESS = "Sucessfully Added";
	private static final String FAIL = "Unsucessfull";

//	Search A Product By Category
//	@PreAuthorize(value = "hasAnyRole('CUSTOMER','ADMIN')")
	@PostMapping("/searchCategory")
	public ResponseEntity<AppResponse> searchCategory(@RequestBody @Valid SearchByCategory searchByCategory) {
		List<Product> searchCategory = customerService.searchCategory(searchByCategory);
		if (searchCategory != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(searchCategory)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Search A Product By Name
	@PostMapping("/searchName")
//	@PreAuthorize(value = "hasAnyRole('CUSTOMER','ADMIN')")
	public ResponseEntity<AppResponse> searchName(@RequestBody @Valid SearchByName searchByName) {
		List<Product> searchName = customerService.searchName(searchByName);
		if (searchName != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(searchName)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Sort the product based on price of category (low to high)
	@PostMapping("/sortCategoryPriceLowToHigh")
//	@PreAuthorize(value = "hasAnyRole('CUSTOMER','ADMIN')")
	public ResponseEntity<AppResponse> sortByPriceLowToHigh(@RequestBody @Valid SearchByCategory searchByCategory) {
		List<Product> sortByPriceLowToHigh = customerService.sortByPriceLowToHigh(searchByCategory);
		if (sortByPriceLowToHigh != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(sortByPriceLowToHigh)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}

	}

//	Sort the product based on price of category (high to low)
	@PostMapping("/sortCategoryPriceHighToLow")
	public ResponseEntity<AppResponse> sortByPriceHighToLow(@RequestBody @Valid SearchByCategory searchByCategory) {
		List<Product> sortByPriceHighToLow = customerService.sortByPriceHighToLow(searchByCategory);
		if (sortByPriceHighToLow != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(sortByPriceHighToLow)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Sort the product based on price of name (low to high)
	@PostMapping("/sortNamePriceLowToHigh")
	public ResponseEntity<AppResponse> sortByNamePriceLowToHigh(@RequestBody @Valid SearchByName searchByName) {
		List<Product> sortByNamePriceLowToHigh = customerService.sortByNamePriceLowToHigh(searchByName);
		if (sortByNamePriceLowToHigh != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(sortByNamePriceLowToHigh)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Sort the product based on price of name (high to low)
	@PostMapping("/sortNamePriceHighToLow")
	public ResponseEntity<AppResponse> sortByNamePriceHighToLow(@RequestBody @Valid SearchByName searchByName) {
		List<Product> sortByNamePriceHighToLow = customerService.sortByNamePriceHighToLow(searchByName);
		if (sortByNamePriceHighToLow != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(sortByNamePriceHighToLow)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	sort Category Alphabet Ascending
	@PostMapping("/sortCategoryAlphabetAscending")
	public ResponseEntity<AppResponse> sortCategoryAlphabetAscending(@RequestBody @Valid SearchByCategory searchByCategory) {
		List<Product> sortCategoryAlphabetAscending = customerService.sortCategoryAlphabetAscending(searchByCategory);
		if (sortCategoryAlphabetAscending != null) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message(SUCCESS)
							.data(Arrays.asList(sortCategoryAlphabetAscending)).status(200).build(),
					HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}

	}

//	sort Category Alphabet Descending
	@PostMapping("/sortCategoryAlphabetDescending")
	public ResponseEntity<AppResponse> sortCategoryAlphabetDescending(@RequestBody @Valid SearchByCategory searchByCategory) {
		List<Product> sortCategoryAlphabetDescending = customerService.sortCategoryAlphabetDescending(searchByCategory);
		if (sortCategoryAlphabetDescending != null) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message(SUCCESS)
							.data(Arrays.asList(sortCategoryAlphabetDescending)).status(200).build(),
					HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Sort the Products based on name alphabetically (a-z)
	@PostMapping("/sortNameAlphabetAscending")
	public ResponseEntity<AppResponse> sortNameAlphabetAscending(@RequestBody @Valid SearchByName searchByName) {
		List<Product> sortNameAlphabetAscending = customerService.sortNameAlphabetAscending(searchByName);
		if (sortNameAlphabetAscending != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(sortNameAlphabetAscending)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Sort the Products based on name alphabetically (z-a)
	@PostMapping("/sortNameAlphabetDescending")
	public ResponseEntity<AppResponse> sortNameAlphabetDescending(@RequestBody @Valid SearchByName searchByName) {
		List<Product> sortNameAlphabetDescending = customerService.sortNameAlphabetDescending(searchByName);
		if (sortNameAlphabetDescending != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(sortNameAlphabetDescending)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Adding Billing Address of Customer
	@PostMapping("/addBillingAddress/{id}")
	public ResponseEntity<AppResponse> billingAddress(@PathVariable Integer id,
			@RequestBody @Valid BillingAddressDto addressDto) {
		BillingAddressDto billingAddress = customerService.billingAddress(addressDto, id);
		if (billingAddress != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(billingAddress)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}

	}

//	Update Billing Address of Customer
	@PutMapping("/updateBillingAddress")
	public ResponseEntity<AppResponse> updateBillingAddress(@RequestBody @Valid UpdateBillingAddress updateBillingAddress) {
		UpdateBillingAddress updateBillingAdd = customerService.updateBillingAddress(updateBillingAddress);
		if (updateBillingAdd != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(updateBillingAdd)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Deleting Billing Address of Customer
	@DeleteMapping("/deleteBillingAddress")
	public ResponseEntity<AppResponse> deleteBillingAddress(@RequestBody @Valid DeleteBillingAddress deleteBillingAddress) {
		String deleteBillingAddressMsg = customerService.deleteBillingAddress(deleteBillingAddress);
		if (deleteBillingAddressMsg != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(deleteBillingAddressMsg)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Adding Shipping Address of Customer
	@PostMapping("/addShippingAddress/{id}")
	@PreAuthorize(value = "hasAnyRole('CUSTOMER','ADMIN')")
	public ResponseEntity<AppResponse> shippingAddress(@PathVariable Integer id,
			@RequestBody @Valid ShippingAddressDto shippingAddressDto) {
		ShippingAddressDto shippingAddress = customerService.shippingAddress(shippingAddressDto, id);
		if (shippingAddress != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(shippingAddress)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Updating Shipping Address of Customer
	@PutMapping("/updateShippingAddress")
	public ResponseEntity<AppResponse> updateShippingAddress(@RequestBody @Valid UpdateShippingAddress updateShippingAddress) {
		UpdateShippingAddress updatedShippingAddress = customerService.updateShippingAddress(updateShippingAddress);
		if (updatedShippingAddress != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(updatedShippingAddress)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Updating Shipping Address of Customer
	@DeleteMapping("/deleteShippingAddress")
	public ResponseEntity<AppResponse> deleteShippingAddress(@RequestBody @Valid DeleteShippingAddress deleteShippingAddress) {
		String address = customerService.deleteShippingAddress(deleteShippingAddress);
		if (address != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS).data(Arrays.asList(address))
					.status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	getting both shipping and billing addresses
	@GetMapping("/allAddresses/{id}")
	public ResponseEntity<AppResponse> allAddresses(@PathVariable Integer id) {
		List<Object> allAddresses = customerService.allAddresses(id);
		if (allAddresses != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(allAddresses)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	Adding item to cart
	@PostMapping("/addToCart")
	public ResponseEntity<AppResponse> addToCart(@RequestBody @Valid ProductOrder productOrder) {
		CartItemDto addedToCart = customerService.addToCart(productOrder);
		if (addedToCart != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(addedToCart)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

//	getting cart details
	@GetMapping("/cartDecartDetails/{id}")
	public ResponseEntity<AppResponse> cartDetails(@PathVariable Integer id) {
		Optional<CartItem> cartDetails = customerService.cartDetails(id);
		return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS).data(Arrays.asList(cartDetails))
				.status(200).build(), HttpStatus.ACCEPTED);

	}

//	getting total price
	@GetMapping("/cartPrice/{id}")
	public ResponseEntity<AppResponse> cartPrice(@PathVariable Integer id) {
		Double cartPrice = customerService.cartPrice(id);
		if (cartPrice != null) {

			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(cartPrice)).status(200).build(), HttpStatus.ACCEPTED);
		} else

		{
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}
}
