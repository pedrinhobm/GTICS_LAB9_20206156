package com.example.clase9webservice.controller;

import com.example.clase9webservice.entity.Product;
import com.example.clase9webservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    final ProductRepository productRepository;

    public ProductoController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/api/product")
    public List<Product> lista(){
        return productRepository.findAll();
    }

    @GetMapping("/api/product2")
    public List<Product> lista2(){
        return productRepository.findAll();
    }
}
