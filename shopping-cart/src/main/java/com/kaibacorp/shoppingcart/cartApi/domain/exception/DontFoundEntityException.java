package com.kaibacorp.shoppingcart.cartApi.domain.exception;

public class DontFoundEntityException extends RuntimeException{
    private static final long serialVersionUID= 1L;

    public DontFoundEntityException(String msg) {
        super(msg);
    }
}
