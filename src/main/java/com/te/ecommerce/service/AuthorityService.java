package com.te.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.te.ecommerce.dto.AddProduct;
import com.te.ecommerce.dto.DeleteProduct;
import com.te.ecommerce.dto.FindCustomer;
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.dto.ProductReload;
import com.te.ecommerce.dto.SalesOrderId;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.SalesOrder;

public interface AuthorityService {

	AddProduct addProduct(AddProduct addProduct);

	ProductReload deleteProduct(DeleteProduct deleteProduct);

	ProductDto modifyProduct(ProductDto productDto);

	List<SalesOrder> allSalesOrder();

	SalesOrder individualSalesOrder(SalesOrderId orderId);

	Optional<Customer> customerDetails(FindCustomer findCustomer);

}
