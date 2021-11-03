package com.kaibacorp.shoppingcart.cartApi.domain.service;

import com.kaibacorp.shoppingcart.cartApi.domain.exception.DontFoundEntityException;
import com.kaibacorp.shoppingcart.cartApi.domain.exception.ServiceException;
import com.kaibacorp.shoppingcart.cartApi.domain.model.Cart;
import com.kaibacorp.shoppingcart.cartApi.domain.model.Item;
import com.kaibacorp.shoppingcart.cartApi.domain.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {

    private CartRepository cartRepository;

    public Cart addItem(Integer id, Item item){
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if(savedCart.equals(Optional.empty()))
            cart = new Cart(id);
        else
            cart = savedCart.get();
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    public Cart findCart(Integer id){
        return cartRepository.findById(id).
                orElseThrow(()->new DontFoundEntityException("Don't found this Cart."));
    }

    public void deleteCart(Integer id){
        if(cartRepository.findById(id).equals(Optional.empty()))
            throw new ServiceException("Invalid Cart! Id "+id+" doesn't exist");
        cartRepository.deleteById(id);
    }
}
