package com.kaibacorp.shoppingcart.cartApi.domain.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@RedisHash("item")
public class Item {

    private Integer productId;
    private Integer amount;

    public Item(){}

    public Item(Integer productId, Integer amount){
        this.productId=productId;
        this.amount=amount;
    }
}
