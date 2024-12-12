package com.github.maaky1.product_management.service;

import com.github.maaky1.product_management.entity.ProductEntity;
import com.github.maaky1.product_management.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final List<ProductEntity> products = new ArrayList<>();
    private long currentId = 1L;

    // Get all products
    public List<ProductModel> getAllProducts() {
        return products.stream()
                .map(product -> new ProductModel()
                        .setIdProduk(product.getIdProduk())
                        .setNamaProduk(product.getNamaProduk())
                        .setHarga(product.getHarga()))
                .collect(Collectors.toList());
    }

    // Get product by Id
    public ProductModel getProductById(long idProduct) {
        return products.stream()
                .filter(product -> product.getIdProduk() == idProduct)
                .findFirst()
                .map(product -> new ProductModel()
                        .setIdProduk(product.getIdProduk())
                        .setNamaProduk(product.getNamaProduk())
                        .setHarga(product.getHarga()))
                .orElse(null);
    }

    // Add Product
    public ProductModel addProduct(ProductModel productModel) {
        ProductEntity product = new ProductEntity()
                .setIdProduk(currentId++)
                .setNamaProduk(productModel.getNamaProduk())
                .setHarga(productModel.getHarga());
        products.add(product);

        return new ProductModel()
                .setIdProduk(product.getIdProduk())
                .setNamaProduk(product.getNamaProduk())
                .setHarga(product.getHarga());
    }

    public void updateProduct(long idProduct, ProductModel productModel) {
        products.stream()
                .filter(product -> product.getIdProduk() == idProduct)
                .findFirst()
                .ifPresent(existingProduct -> existingProduct
                        .setNamaProduk(productModel.getNamaProduk().isEmpty() ? existingProduct.getNamaProduk() : productModel.getNamaProduk())
                        .setHarga(productModel.getHarga()));
    }

    public boolean deleteProduct(long idProduct) {
        return products.removeIf(product -> product.getIdProduk() == idProduct);
    }
}
