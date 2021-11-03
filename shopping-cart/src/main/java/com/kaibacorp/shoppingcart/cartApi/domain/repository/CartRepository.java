package com.kaibacorp.shoppingcart.cartApi.domain.repository;

import com.kaibacorp.shoppingcart.cartApi.domain.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface CartRepository extends CrudRepository<Cart,Integer> {

}
