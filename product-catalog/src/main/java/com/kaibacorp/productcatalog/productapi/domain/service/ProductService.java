package com.kaibacorp.productcatalog.productapi.domain.service;

import com.kaibacorp.productcatalog.productapi.domain.exception.DontFoundEntityException;
import com.kaibacorp.productcatalog.productapi.domain.exception.ServiceException;
import com.kaibacorp.productcatalog.productapi.domain.model.Product;
import com.kaibacorp.productcatalog.productapi.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    public Product getById(Integer id){
        return productRepository.findById(id).orElseThrow(()->
                new DontFoundEntityException("Don't found Product with id "+id));
    }

    public Product save(Product product){
        existById(product.getId(),"This id value is already being used!",1);
        return productRepository.save(product);
    }

    public void delete(Integer id){
        existById(id,"This id value doesn't exist in our database!",0);
        productRepository.deleteById(id);
    }

    private void existById(Integer id, String msg, Integer type){
        if(productRepository.findById(id).equals(Optional.empty()) && type==0)
            throw new DontFoundEntityException(msg);
        if(!productRepository.findById(id).equals(Optional.empty()) && type==1)
            throw new ServiceException(msg);
    }
}
