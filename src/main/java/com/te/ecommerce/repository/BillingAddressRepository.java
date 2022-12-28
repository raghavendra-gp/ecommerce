package com.te.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecommerce.entity.BillingAddress;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Integer> {

}
