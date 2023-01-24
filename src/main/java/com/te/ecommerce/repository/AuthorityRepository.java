package com.te.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecommerce.entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer>{

}
