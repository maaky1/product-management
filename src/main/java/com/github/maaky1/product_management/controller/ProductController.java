package com.github.maaky1.product_management.controller;

import com.github.maaky1.product_management.model.ProductModel;
import com.github.maaky1.product_management.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get-all")
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get-by-id/{idProduct}")
    public ProductModel getProductById(@PathVariable long idProduct) {
        return productService.getProductById(idProduct);
    }

    @PostMapping("/insert")
    public ProductModel addProduct(@RequestBody ProductModel payload) {
        return productService.addProduct(payload);
    }

    @PutMapping("/update/{idProduct}")
    public void updateProduct(@PathVariable long idProduct, @RequestBody ProductModel payload) {
        productService.updateProduct(idProduct, payload);
    }

    @DeleteMapping("/delete/{idProduct}")
    public boolean deleteProduct(@PathVariable long idProduct) {
        return productService.deleteProduct(idProduct);
    }
}
