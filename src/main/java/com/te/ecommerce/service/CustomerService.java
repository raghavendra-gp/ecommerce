package com.te.ecommerce.service;

import java.util.List;

import com.te.ecommerce.dto.BillingAddressDto;
import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.CustomerRegistration;
import com.te.ecommerce.dto.DeleteBillingAddress;
import com.te.ecommerce.dto.DeleteShippingAddress;
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.dto.ProductOrder;
import com.te.ecommerce.dto.SearchByCategory;
import com.te.ecommerce.dto.SearchByName;
import com.te.ecommerce.dto.ShippingAddressDto;
import com.te.ecommerce.dto.UpdateBillingAddress;
import com.te.ecommerce.dto.UpdateShippingAddress;

public interface CustomerService {

	CustomerRegistration registerCustomer(CustomerRegistration registerCustomer);

	List<ProductDto> searchCategory(SearchByCategory searchByCategory);

	List<ProductDto> searchName(SearchByName searchByName);

	List<ProductDto> sortByPriceLowToHigh(SearchByCategory searchByCategory);

	List<ProductDto> sortByPriceHighToLow(SearchByCategory searchByCategory);

	List<ProductDto> sortByNamePriceLowToHigh(SearchByName searchByName);

	List<ProductDto> sortByNamePriceHighToLow(SearchByName searchByName);

	List<ProductDto> sortCategoryAlphabetAscending(SearchByCategory searchByCategory);

	List<ProductDto> sortCategoryAlphabetDescending(SearchByCategory searchByCategory);

	List<ProductDto> sortNameAlphabetAscending(SearchByName searchByName);

	List<ProductDto> sortNameAlphabetDescending(SearchByName searchByName);

	BillingAddressDto billingAddress(BillingAddressDto addressDto, Integer id);

	ShippingAddressDto shippingAddress(ShippingAddressDto shippingAddressDto, Integer id);

	UpdateBillingAddress updateBillingAddress(UpdateBillingAddress updateBillingAddress);

	String deleteBillingAddress(DeleteBillingAddress deleteBillingAddress);

	UpdateShippingAddress updateShippingAddress(UpdateShippingAddress updateShippingAddress);

	String deleteShippingAddress(DeleteShippingAddress deleteShippingAddress);

	List<Object> allAddresses(Integer id);

	CartItemDto addToCart(Integer id, ProductOrder productOrder, Integer productUnit);

}
