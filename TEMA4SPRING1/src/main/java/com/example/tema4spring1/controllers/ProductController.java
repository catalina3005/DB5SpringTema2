package com.example.tema4spring1.controllers;

import com.example.tema4spring1.model.Products;
import com.example.tema4spring1.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductsService productService;

    @GetMapping
    public List<Products> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Products saveProduct(@RequestBody Products product){
        return productService.saveProducts(product);
    }

    @PutMapping
    public Products updateProduct(@RequestBody Products product){
        return productService.updateProducts(product, product.getId());
    }

}
