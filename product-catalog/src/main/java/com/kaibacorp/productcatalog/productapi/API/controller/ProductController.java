package com.kaibacorp.productcatalog.productapi.API.controller;

import com.kaibacorp.productcatalog.productapi.domain.model.Product;
import com.kaibacorp.productcatalog.productapi.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product find(@PathVariable Integer id){
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ productService.delete(id);}

}

