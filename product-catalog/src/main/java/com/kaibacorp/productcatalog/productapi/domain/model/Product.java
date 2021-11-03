package com.kaibacorp.productcatalog.productapi.domain.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@ToString
@Document(indexName = "product",type = "catalog")
public class Product {

    @Id
    private Integer id;
    private String name;
    private Integer amount;

    public Product(){}

    public Product(Integer id, String name, Integer amount){
        this.id=id;
        this.name=name;
        this.amount=amount;
    }
}
