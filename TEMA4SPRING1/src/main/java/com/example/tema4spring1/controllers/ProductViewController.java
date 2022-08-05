package com.example.tema4spring1.controllers;

import com.example.tema4spring1.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class ProductViewController {

    private final ProductsService productService;

    @GetMapping("products")
    public String getProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
}
