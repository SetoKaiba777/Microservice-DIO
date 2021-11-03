package com.kaibacorp.productcatalog.productapi.domain.repository;

import com.kaibacorp.productcatalog.productapi.domain.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
