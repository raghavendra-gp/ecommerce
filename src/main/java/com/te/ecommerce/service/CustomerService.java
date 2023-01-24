package com.te.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.te.ecommerce.dto.BillingAddressDto;
import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.CustomerRegistration;
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

public interface CustomerService {

	CustomerRegistration registerCustomer(CustomerRegistration registerCustomer);

	List<Product> searchCategory(SearchByCategory searchByCategory);

	List<Product> searchName(SearchByName searchByName);

	List<Product> sortByPriceLowToHigh(SearchByCategory searchByCategory);

	List<Product> sortByPriceHighToLow(SearchByCategory searchByCategory);

	List<Product> sortByNamePriceLowToHigh(SearchByName searchByName);

	List<Product> sortByNamePriceHighToLow(SearchByName searchByName);

	List<Product> sortCategoryAlphabetAscending(SearchByCategory searchByCategory);

	List<Product> sortCategoryAlphabetDescending(SearchByCategory searchByCategory);

	List<Product> sortNameAlphabetAscending(SearchByName searchByName);

	List<Product> sortNameAlphabetDescending(SearchByName searchByName);

	BillingAddressDto billingAddress(BillingAddressDto addressDto, Integer id);

	ShippingAddressDto shippingAddress(ShippingAddressDto shippingAddressDto, Integer id);

	UpdateBillingAddress updateBillingAddress(UpdateBillingAddress updateBillingAddress);

	String deleteBillingAddress(DeleteBillingAddress deleteBillingAddress);

	UpdateShippingAddress updateShippingAddress(UpdateShippingAddress updateShippingAddress);

	String deleteShippingAddress(DeleteShippingAddress deleteShippingAddress);

	List<Object> allAddresses(Integer id);

	CartItemDto addToCart(ProductOrder productOrder);

	Optional<CartItem> cartDetails(Integer id);

	Double cartPrice(Integer id);

}
