package com.example.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
