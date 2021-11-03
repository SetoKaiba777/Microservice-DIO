package com.kaibacorp.shoppingcart.cartApi.API.controller;

import com.kaibacorp.shoppingcart.cartApi.domain.model.Cart;
import com.kaibacorp.shoppingcart.cartApi.domain.model.Item;
import com.kaibacorp.shoppingcart.cartApi.domain.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cart")
public class CartController {

    private CartService cartService;

    @PostMapping("/{id}")
    public Cart addItems(@PathVariable Integer id, @RequestBody Item item){
        return cartService.addItem(id,item);
    }

    @GetMapping("/{id}")
    public Cart findCart(@PathVariable Integer id){
        return cartService.findCart(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        cartService.deleteCart(id);
    }
}
