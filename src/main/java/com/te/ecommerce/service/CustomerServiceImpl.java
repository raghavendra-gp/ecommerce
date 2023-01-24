	package com.te.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.te.ecommerce.entity.BillingAddress;
import com.te.ecommerce.entity.Cart;
import com.te.ecommerce.entity.CartItem;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.entity.SalesOrder;
import com.te.ecommerce.entity.ShippingAddress;
import com.te.ecommerce.entity.User;
import com.te.ecommerce.exceptions.AddressException;
import com.te.ecommerce.exceptions.AddressNotFoundException;
import com.te.ecommerce.exceptions.CartItemException;
import com.te.ecommerce.exceptions.CustomerException;
import com.te.ecommerce.exceptions.ProductNotFoundException;
import com.te.ecommerce.exceptions.SortException;
import com.te.ecommerce.repository.BillingAddressRepository;
import com.te.ecommerce.repository.CartItemRepository;
import com.te.ecommerce.repository.CartRepository;
import com.te.ecommerce.repository.CustomerRepository;
import com.te.ecommerce.repository.ProductRepository;
import com.te.ecommerce.repository.SalesOrderRepository;
import com.te.ecommerce.repository.ShippingAddressRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BillingAddressRepository billingAddressRepository;

	@Autowired
	private ShippingAddressRepository shippingAddressRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private SalesOrderRepository salesOrderRepository;

	@Override
	public CustomerRegistration registerCustomer(CustomerRegistration registerCustomer) {
		User user = new User();
		user.setEmailid(registerCustomer.getEmailid());
		Customer customer = new Customer();
		customer.setUser(user);
		BeanUtils.copyProperties(registerCustomer, customer);
		customerRepository.save(customer);

		registerCustomer.setFirstName(customer.getFirstName());
		registerCustomer.setLastName(customer.getLastName());
		return registerCustomer;
	}

//	Searching a product Based on the category
	@Override
	public List<Product> searchCategory(SearchByCategory searchByCategory) {
		Product product = new Product();
		BeanUtils.copyProperties(searchByCategory, product);
//		customerRepository.fin
//		List<ProductDto> allProductsOnCategory = customerRepository.findAllByCategory(product.getCategory());
		List<Product> allByCategory = productRepository.findAllByCategory(product.getCategory());
		if (allByCategory != null) {
			return allByCategory;
		} else {
			throw new ProductNotFoundException("Couldn't find the product");
		}
	}

//	Searching a product Based on the name
	@Override
	public List<Product> searchName(SearchByName searchByName) {
		Product product = new Product();
		BeanUtils.copyProperties(searchByName, product);
		List<Product> allByName = productRepository.findAllByName(product.getName());
//		List<ProductDto> allByName = productRepository.findByName(product.getName());
//		List<ProductDto> findAll = productRepository.findAll(product.getName());
		if (allByName != null) {
			return allByName;
		} else {
			throw new ProductNotFoundException("Couldn't find the product");

		}
	}

//	Sort the Products based on category the price (Low To High)
	@Override
	public List<Product> sortByPriceLowToHigh(SearchByCategory searchByCategory) {
		Product product = new Product();
		BeanUtils.copyProperties(searchByCategory, product);
		List<Product> allProductsOnCategory = productRepository.findAllByCategory(product.getCategory());
		List<Product> allProductsOnCategoryPriceAscending = allProductsOnCategory.stream()
				.sorted((o1, o2) -> (int) (o1.getPrice() - o2.getPrice())).collect(Collectors.toList());
		if (allProductsOnCategoryPriceAscending != null) {
			return allProductsOnCategoryPriceAscending;
		} else {
			throw new SortException("Error Occured While Sorting");
		}
	}

//	Sort the Products based on category the price (High To Low)
	@Override
	public List<Product> sortByPriceHighToLow(SearchByCategory searchByCategory) {
		Product product = new Product();
		BeanUtils.copyProperties(searchByCategory, product);
		List<Product> allProductsOnCategory = productRepository.findAllByCategory(product.getCategory());
		List<Product> allProductsOnCategoryPriceDescending = allProductsOnCategory.stream()
				.sorted((o1, o2) -> (int) (o2.getPrice() - o1.getPrice())).collect(Collectors.toList());
		if (allProductsOnCategoryPriceDescending != null) {
			return allProductsOnCategoryPriceDescending;
		} else {
			throw new SortException("Error Occured While Sorting");
		}
	}

//	Sort the Products based on Name the price (Low To High)
	@Override
	public List<Product> sortByNamePriceLowToHigh(SearchByName searchByName) {
		Product product = new Product();
		BeanUtils.copyProperties(searchByName, product);
		List<Product> allProductOnName = productRepository.findByName(product.getName());
		List<Product> allProductsOnNamePriceAscending = allProductOnName.stream()
				.sorted((o1, o2) -> (int) (o1.getPrice() - o2.getPrice())).collect(Collectors.toList());
		if (allProductsOnNamePriceAscending != null) {
			return allProductsOnNamePriceAscending;
		} else {
			throw new SortException("Error Occured While Sorting");
		}
	}

//	Sort the Products based on Name the price (High To Low)
	@Override
	public List<Product> sortByNamePriceHighToLow(SearchByName searchByName) {
		Product product = new Product();
		BeanUtils.copyProperties(searchByName, product);
		List<Product> allProductOnName = productRepository.findByName(product.getName());
		List<Product> allProductsOnNamePriceDescending = allProductOnName.stream()
				.sorted((o1, o2) -> (int) (o2.getPrice() - o1.getPrice())).collect(Collectors.toList());
		if (allProductsOnNamePriceDescending != null) {
			return allProductsOnNamePriceDescending;
		} else {
			throw new SortException("Error Occured While Sorting");
		}
	}

//	Sort the Products based on Category alphabetically (a-z)
	@Override
	public List<Product> sortCategoryAlphabetAscending(SearchByCategory searchByCategory) {
		Product product = new Product();
		BeanUtils.copyProperties(searchByCategory, product);
		List<Product> allProductsOnCategory = productRepository.findAllByCategory(product.getCategory());

		List<Product> sortCategoryAlphabetAscending = allProductsOnCategory.stream()
				.sorted((o1, o2) -> o1.getCategory().compareTo(o2.getCategory())).collect(Collectors.toList());

		if (sortCategoryAlphabetAscending != null) {
			return sortCategoryAlphabetAscending;
		} else {
			throw new SortException("Error Occured While Sorting");
		}
	}

//	Sort the Products based on Category alphabetically (z-a)
	@Override
	public List<Product> sortCategoryAlphabetDescending(SearchByCategory searchByCategory) {
		Product product = new Product();
		BeanUtils.copyProperties(searchByCategory, product);
		List<Product> allProductsOnCategory = productRepository.findAllByCategory(product.getCategory());
		List<Product> sortCategoryAlphabetDescending = allProductsOnCategory.stream()
				.sorted((o1, o2) -> o2.getCategory().compareTo(o1.getCategory())).collect(Collectors.toList());
		if (sortCategoryAlphabetDescending != null) {
			return sortCategoryAlphabetDescending;
		} else {
			throw new SortException("Error Occured While Sorting");
		}
	}

//	Sort the Products based on Name alphabetically (a-z)
	@Override
	public List<Product> sortNameAlphabetAscending(SearchByName searchByName) {
		Product product = new Product();
		BeanUtils.copyProperties(searchByName, product);
		List<Product> allProductOnName = productRepository.findByName(product.getName());
		List<Product> sortNameAlphabetAscending = allProductOnName.stream()
				.sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		if (sortNameAlphabetAscending != null) {
			return sortNameAlphabetAscending;
		} else {
			throw new SortException("Error Occured While Sorting");
		}
	}

//	Sort the Products based on Name alphabetically (z-a)
	@Override
	public List<Product> sortNameAlphabetDescending(SearchByName searchByName) {
		Product product = new Product();
		BeanUtils.copyProperties(searchByName, product);
		List<Product> allProductOnName = productRepository.findByName(product.getName());
		List<Product> sortNameAlphabetDescending = allProductOnName.stream()
				.sorted((o1, o2) -> o2.getName().compareTo(o1.getName())).collect(Collectors.toList());
		if (sortNameAlphabetDescending != null) {
			return sortNameAlphabetDescending;
		} else {
			throw new SortException("Error Occured While Sorting");
		}
	}

//	Adding billing Address of customer
	@Override
	public BillingAddressDto billingAddress(BillingAddressDto addressDto, Integer id) {
		Customer customer = new Customer();
		customer.setId(id);
		Customer customerDet = customerRepository.findById(customer.getId()).orElseThrow(CustomerException::new);

		if (customerDet != null) {

			BillingAddress billingAddress = new BillingAddress();

			BeanUtils.copyProperties(addressDto, billingAddress);

			BillingAddress savedBillingAddress = billingAddressRepository.save(billingAddress);

			if (savedBillingAddress != null) {
				customerDet.setBillingAddress(savedBillingAddress);
				customerRepository.save(customerDet);
				return addressDto;
			} else {
				throw new AddressException("couldnt add the address");
			}

		} else {
			throw new CustomerException("Customer Exception");
		}

	}

//	Updating billing Address of customer
	@Override
	public UpdateBillingAddress updateBillingAddress(UpdateBillingAddress updateBillingAddress) {

		BillingAddress billingAddress = new BillingAddress();
		BeanUtils.copyProperties(updateBillingAddress, billingAddress);
		BillingAddress billingDbAddress = billingAddressRepository.findById(billingAddress.getId())
				.orElseThrow(AddressNotFoundException::new);
		if (billingDbAddress != null) {
			if (billingDbAddress.getId() == updateBillingAddress.getId()) {
				billingAddressRepository.save(billingAddress);
				return updateBillingAddress;
			} else {
				throw new AddressException("Couldn't save the billing address");
			}
		} else {
			throw new AddressException("Something went wrong, try after sometime");
		}

	}

//	Deleting billing Address of customer
	@Override
	public String deleteBillingAddress(DeleteBillingAddress deleteBillingAddress) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(deleteBillingAddress, customer);
		Integer billingAddressId = customerRepository.findByBillingAddressId(customer.getId());
		BillingAddress billingAddress = new BillingAddress();
		billingAddress.setId(billingAddressId);
		Optional<BillingAddress> billingAddressDetails = billingAddressRepository.findById(billingAddress.getId());
		if (billingAddressDetails != null) {
			billingAddressRepository.deleteById(billingAddress.getId());
			return "Billing Address Deleted";
		} else {
			throw new AddressException("Couldn't delete the billing address");
		}

	}

//	Adding Shippping Address of customer
	@Override
	public ShippingAddressDto shippingAddress(ShippingAddressDto shippingAddressDto, Integer id) {
		Customer customer = new Customer();
		customer.setId(id);
		Customer customerDet = customerRepository.findById(customer.getId()).orElse(null);

		if (customerDet != null) {

			ShippingAddress shippingAddress = new ShippingAddress();

			BeanUtils.copyProperties(shippingAddressDto, shippingAddress);

			ShippingAddress saveShippingAddress = shippingAddressRepository.save(shippingAddress);

			customerDet.setShippingAddress(saveShippingAddress);
			customerRepository.save(customerDet);

			if (saveShippingAddress != null) {
				return shippingAddressDto;
			} else {
				throw new AddressException("Shipping Address is not added at the momment. Try after sometime.");
			}

		} else {
			throw new CustomerException("Customer Not Found");
		}

	}

//	Updating Shipping Address of customer
	@Override
	public UpdateShippingAddress updateShippingAddress(UpdateShippingAddress updateShippingAddress) {
		ShippingAddress shippingAddress = new ShippingAddress();
		BeanUtils.copyProperties(updateShippingAddress, shippingAddress);
		ShippingAddress shippingDbAddress = shippingAddressRepository.findById(shippingAddress.getId())
				.orElseThrow(AddressNotFoundException::new);
		if (shippingDbAddress != null) {
			if (shippingDbAddress.getId() == updateShippingAddress.getId()) {
				shippingAddressRepository.save(shippingAddress);
				return updateShippingAddress;
			} else {
				throw new AddressException("Couldn't save the shipping address");
			}
		} else {
			throw new AddressException("Something went wrong, try after sometime");
		}
	}

//	Deleting Shipping Address of customer
	@Override
	public String deleteShippingAddress(DeleteShippingAddress deleteShippingAddress) {
		Customer customer = new Customer();
		ShippingAddress shippingAddress = new ShippingAddress();
		BeanUtils.copyProperties(deleteShippingAddress, customer);
		Integer shippingAddressId = customerRepository.findByShippingAddressId(customer.getId());
		shippingAddress.setId(shippingAddressId);
		Optional<ShippingAddress> shippingAddressDetails = shippingAddressRepository.findById(shippingAddress.getId());
		if (shippingAddressDetails != null) {
			billingAddressRepository.deleteById(shippingAddress.getId());
			return "Shipping Address Deleted";
		} else {
			throw new AddressException("Couldn't delete the shipping address");
		}

	}

//	Getting both the addresses
	@Override
	public List<Object> allAddresses(Integer id) {

		List<Object> addressList = new ArrayList<>();
		Customer customer = new Customer();
		customer.setId(id);

		Customer customerDet = customerRepository.findById(customer.getId()).orElseThrow(CustomerException::new);
		if (customerDet != null) {

			BillingAddress billAddress = customerDet.getBillingAddress();
			if (billAddress != null) {
				addressList.add(billAddress);
			} else {
				throw new AddressException("Billing Address Not Found");
			}

			ShippingAddress shipAddress = customerDet.getShippingAddress();
			if (shipAddress != null) {
				addressList.add(shipAddress);
			} else {
				throw new AddressException("Shipping Address Not Found");
			}
			return addressList;
		} else {
			throw new CustomerException("Customer not found");
		}

	}

//	Adding item to the Cart
	@Override
	public CartItemDto addToCart(ProductOrder productOrder) {

		CartItem cartItem = new CartItem();
		
		Optional<Product> findById = productRepository.findById(productOrder.getId());
		Product prod = findById.get();

//		setting quantity of cartItem
		cartItem.setQuantity(productOrder.getQuantity());

//		setting price of cartItem
		cartItem.setPrice(prod.getPrice());

//		copying from dto to entity class and setting it to cartItem
		Product product = new Product();
		BeanUtils.copyProperties(productOrder, product);

//		Product productDet = productRepository.findById(product.getId()).orElseThrow(ProductNotFoundException::new);

		if (prod.getId().equals(productOrder.getId())) {
			cartItem.setProduct(product);
		}

//		Calculating the total price
		Double price = prod.getPrice();
		Double orderQuantity = Double.valueOf(productOrder.getQuantity());

		Double total = orderQuantity * price;

//		Saving to cart and getting the whole object
		Cart cart = new Cart();
		cart.setTotalPrice(total);
		Cart savedPrice = cartRepository.save(cart);
		if (savedPrice != null) {
//			setting it to cartItem
			cartItem.setCart(savedPrice);

//			setting cart id to customer
			Customer customer = new Customer();
			customer.setId(productOrder.getCustId());
			Customer customerDet = customerRepository.findById(customer.getId()).orElse(null);

//			saving cart to salesorder
			SalesOrder salesOrder = new SalesOrder();
			salesOrder.setBillingAddress(customerDet.getBillingAddress());
			salesOrder.setShippingAddress(customerDet.getShippingAddress());
			salesOrder.setCart(cart);

//			if (customerDet != null) {
				customerDet.setCart(savedPrice);
				salesOrder.setCustomer(customerDet);
				customerRepository.save(customerDet);
				salesOrderRepository.save(salesOrder);
//			} else {
//				throw new CustomerException("customer not found");
//			}
		} else {
			throw new CartItemException("No product in cart");
		}

//		finally saving the cartItem
		CartItem savedCartItem = cartItemRepository.save(cartItem);
		if (savedCartItem != null) {
			CartItemDto cartItemDto = new CartItemDto();
			BeanUtils.copyProperties(savedCartItem, cartItemDto);
			return cartItemDto;
		} else {
			throw new CartItemException("Nothing in cart");
		}

	}

//	getting the cartItem details
	@Override
	public Optional<CartItem> cartDetails(Integer id) {
		return cartItemRepository.findById(id);

	}

	@Override
	public Double cartPrice(Integer id) {

		Optional<Customer> custDet = customerRepository.findById(id);
		Customer customer = custDet.get();
		return customer.getCart().getTotalPrice();
//		Cart cart = new Cart();
//		return custDet.stream().filter(p -> p.getCart() == cart).findFirst();
	}

}
